/*
MIT License

Copyright (c) 2025 Guillaume Legris

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package raygui4j;

/** Outils de dégradés bilinéaires 0xRRGGBBAA (RGBA). Sans dépendance AWT. */
public final class GradientHelper {
    private GradientHelper() {
    }

    /** RGBA → ARGB (utile pour BufferedImage.setRGB). */
    public static int rgbaToArgb(int rgba) {
        int r = (rgba >>> 24) & 0xFF;
        int g = (rgba >>> 16) & 0xFF;
        int b = (rgba >>> 8) & 0xFF;
        int a = (rgba) & 0xFF;
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    /** Lerp de deux couleurs RGBA (0..1). */
    public static int lerpARGB(int c0, int c1, float t) {
        if (t <= 0f)
            return c0;
        if (t >= 1f)
            return c1;

        int r0 = (c0 >>> 24) & 0xFF, g0 = (c0 >>> 16) & 0xFF, b0 = (c0 >>> 8) & 0xFF, a0 = c0 & 0xFF;
        int r1 = (c1 >>> 24) & 0xFF, g1 = (c1 >>> 16) & 0xFF, b1 = (c1 >>> 8) & 0xFF, a1 = c1 & 0xFF;

        int r = r0 + Math.round((r1 - r0) * t);
        int g = g0 + Math.round((g1 - g0) * t);
        int b = b0 + Math.round((b1 - b0) * t);
        int a = a0 + Math.round((a1 - a0) * t);

        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    private static int clamp255(float v) {
        int i = (int) (v + 0.5f);
        return (i < 0) ? 0 : (i > 255 ? 255 : i);
    }

    // Interpolation de deux canaux 0..255
    private static int lerp8(int a, int b, float t) {
        return clamp255(a + (b - a) * t);
    }

    // Remplit une ligne en **ARGB** directement (prêt pour BufferedImage.setRGB)
    // Coins en **RGBA** (0xRRGGBBAA) comme raygui/raylib.
    public static void fillBilinearRowARGB(int w, int h, int rowIndex, int colTL, int colTR, int colBL, int colBR, int[] dst, int dstOff) {

        if (w <= 0 || h <= 0)
            return;

        float fy = (h == 1) ? 0f : (rowIndex / (float) (h - 1));

        int rtl = (colTL >>> 24) & 0xFF, gtl = (colTL >>> 16) & 0xFF, btl = (colTL >>> 8) & 0xFF, atl = (colTL) & 0xFF;
        int rtr = (colTR >>> 24) & 0xFF, gtr = (colTR >>> 16) & 0xFF, btr = (colTR >>> 8) & 0xFF, atr = (colTR) & 0xFF;
        int rbl = (colBL >>> 24) & 0xFF, gbl = (colBL >>> 16) & 0xFF, bbl = (colBL >>> 8) & 0xFF, abl = (colBL) & 0xFF;
        int rbr = (colBR >>> 24) & 0xFF, gbr = (colBR >>> 16) & 0xFF, bbr = (colBR >>> 8) & 0xFF, abr = (colBR) & 0xFF;

        float rL = rtl + (rbl - rtl) * fy;
        float gL = gtl + (gbl - gtl) * fy;
        float bL = btl + (bbl - btl) * fy;
        float aL = atl + (abl - atl) * fy;

        float rR = rtr + (rbr - rtr) * fy;
        float gR = gtr + (gbr - gtr) * fy;
        float bR = btr + (bbr - btr) * fy;
        float aR = atr + (abr - atr) * fy;

        float invWm1 = (w == 1) ? 0f : 1f / (w - 1f);

        for (int i = 0; i < w; i++) {
            float fx = (w == 1) ? 0f : i * invWm1;

            int r = clamp255(rL + (rR - rL) * fx);
            int g = clamp255(gL + (gR - gL) * fx);
            int b = clamp255(bL + (bR - bL) * fx);
            int a = clamp255(aL + (aR - aL) * fx);

            // **ARGB** pour BufferedImage.setRGB()
            dst[dstOff + i] = (a << 24) | (r << 16) | (g << 8) | b;
        }
    }

    /**
     * Remplit tout le bloc (w*h) RGBA d’un dégradé bilinéaire dans un buffer row-major. 'stride' = pas entre deux lignes (0 => w).
     */
    public static void fillBilinearBlockARGB(int w, int h, int colTL, int colTR, int colBL, int colBR, int[] out, int stride, int offset) {

        if (w <= 0 || h <= 0)
            return;
        if (stride == 0)
            stride = w;

        for (int y = 0; y < h; y++) {
            fillBilinearRowARGB(w, h, y, colTL, colTR, colBL, colBR, out, offset + y * stride);
        }
    }
    
    public static int[] makeBilinearBlockARGB(int w, int h, int colTL, int colTR, int colBL, int colBR) {
        if (w <= 0 || h <= 0)
            return new int[0];
        int[] out = new int[w * h];
        fillBilinearBlockARGB(w, h, colTL, colTR, colBL, colBR, out, /* stride */0, /* offset */0);
        return out;
    }
    
    public static int srcOverRGB(int dstRGB, int srcARGB) {
        int sa = (srcARGB >>> 24) & 0xFF;
        int sr = (srcARGB >>> 16) & 0xFF;
        int sg = (srcARGB >>>  8) & 0xFF;
        int sb = (srcARGB       ) & 0xFF;

        int dr = (dstRGB >>> 16) & 0xFF;
        int dg = (dstRGB >>>  8) & 0xFF;
        int db = (dstRGB       ) & 0xFF;

        int inv = 255 - sa;
        int r = (sr * sa + dr * inv + 127) / 255;
        int g = (sg * sa + dg * inv + 127) / 255;
        int b = (sb * sa + db * inv + 127) / 255;

        return (r << 16) | (g << 8) | b;
    }

    /**
     * Use sampleBilinearRGBA to draw point by point. for (int j = 0; j < h; j++) { for (int i = 0; i < w; i++) { int rgba = GradientHelper.sampleBilinearRGBA(w, h, i, j, colTL,
     * colTR, colBL, colBR); surface.setRGB(x + i, y + j, GradientHelper.rgbaToArgb(rgba)); } }
     */
    public static int sampleBilinearARGB(int w, int h, int px, int py, int colTL, int colTR, int colBL, int colBR) {

        if (w <= 0 || h <= 0)
            return 0;

        float fx = (w == 1) ? 0f : (px / (float) (w - 1));
        float fy = (h == 1) ? 0f : (py / (float) (h - 1));

        int left = lerpARGB(colTL, colBL, fy); // up->down on the left edge
        int right = lerpARGB(colTR, colBR, fy); // up->down on the right edge

        return lerpARGB(left, right, fx); // left->right
    }
//
//    /** Variant to pass normalized coordinates (0..1) */
//    public static int sampleBilinearNormalizedRGBA(float fx, float fy, int colTL, int colTR, int colBL, int colBR) {
//
//        fx = Math.max(0f, Math.min(1f, fx));
//        fy = Math.max(0f, Math.min(1f, fy));
//        int left = lerpRGBA(colTL, colBL, fy);
//        int right = lerpRGBA(colTR, colBR, fy);
//        return lerpRGBA(left, right, fx);
//    }
}
