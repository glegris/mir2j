MIR_HOME=$PWD/..
BUILD_DIR=$MIR_HOME/mir2j/build-java
INCLUDES=$MIR_HOME/mir2j/libc/includes
C2M=$MIR_HOME/c2m
M2J=$MIR_HOME/m2j

mkdir -p $BUILD_DIR
$C2M -I${INCLUDES} -S $MIR_HOME/mir2j/libc/libc.c -o $BUILD_DIR/libc.mir
$C2M -S $MIR_HOME/mir-tests/mir2j-test.c -o $BUILD_DIR/mir2j-test.mir
$C2M -o $BUILD_DIR/target.bmir $BUILD_DIR/libc.mir $BUILD_DIR/mir2j-test.mir
$C2M -S $BUILD_DIR/target.bmir -o $BUILD_DIR/target.mir
$M2J $BUILD_DIR/target.mir > $BUILD_DIR/Main.java

