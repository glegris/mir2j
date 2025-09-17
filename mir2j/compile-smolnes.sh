MIR_HOME=$PWD/..
BUILD_DIR=$MIR_HOME/mir2j/build-java
LIBC_HOME=$MIR_HOME/mir2j/libc
LIBC_INCLUDE=$LIBC_HOME/includes
SDL2_HOME=$MIR_HOME/mir2j/SDL2
SDL2_INCLUDE=$SDL2_HOME/include
C2M=$MIR_HOME/c2m
M2J=$MIR_HOME/m2j

mkdir -p $BUILD_DIR
$MIR_HOME/c2m -I${SDL2_INCLUDE} -S $MIR_HOME/mir-tests/smolnes/smolnes.c -o $BUILD_DIR/smolnes.mir
$MIR_HOME/c2m -I${SDL2_INCLUDE} -S $SDL2_HOME/SDL2.c -o $BUILD_DIR/sdl2.mir
$C2M -I${LIBC_INCLUDE} -S $LIBC_HOME/libc.c -o $BUILD_DIR/libc.mir
$C2M -o $BUILD_DIR/target.bmir $BUILD_DIR/libc.mir $BUILD_DIR/sdl2.mir $BUILD_DIR/smolnes.mir
$C2M -S $BUILD_DIR/target.bmir -o $BUILD_DIR/target.mir
$M2J $BUILD_DIR/target.mir > $BUILD_DIR/Main.java
