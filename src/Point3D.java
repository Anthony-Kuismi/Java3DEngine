public class Point3D {
    private double xAngle = 1;
    private double yAngle = 1;
    private double zAngle = 1;
    private final double[][] projection = {
            {1, 0, 0},
            {0, 1, 0}
    };

    private final double[][] rotationX = {
            {1, 0, 0},
            {0, Math.cos(xAngle),-Math.sin(xAngle)},
            {0, Math.sin(xAngle), Math.cos(xAngle)},
    };
    private final double[][] rotationY = {
            {Math.cos(yAngle), 0, Math.sin(yAngle)},
            {0, 1, 0},
            {-Math.sin(yAngle), 0, Math.cos(yAngle)},

    };
    private final double[][] rotationZ = {
            {Math.cos(zAngle),-Math.sin(zAngle), 0},
            {Math.sin(zAngle), Math.cos(zAngle), 0},
            {0, 0, 1}
    };
    private final double[][] location = new double[3][1];

    private void updateRotationMatrix(){
        rotationX[1][1]=Math.cos(xAngle);
        rotationX[1][2]=-Math.sin(xAngle);
        rotationX[2][1]=Math.sin(xAngle);
        rotationX[2][2]=Math.cos(xAngle);

        rotationY[0][0]=Math.cos(yAngle);
        rotationY[2][0]=-Math.sin(yAngle);
        rotationY[0][2]=Math.sin(yAngle);
        rotationY[2][2]=Math.cos(yAngle);

        rotationZ[0][0]=Math.cos(zAngle);
        rotationZ[0][1]=-Math.sin(zAngle);
        rotationZ[1][0]=Math.sin(zAngle);
        rotationZ[1][1]=Math.cos(zAngle);
    }

    public Point3D(double x, double y, double z){
        location[0][0] = x;
        location[1][0] = y;
        location[2][0] = z;
    }

    public double getXProjection(){
        updateRotationMatrix();
        double[][] projected = multiplyMatrix(projection, location);
        double[][] rotated = multiplyMatrix(rotationZ,projected);
        rotated = multiplyMatrix(rotationX,rotated);
        return rotated[0][0];
    }

    public double getYProjection(){
        updateRotationMatrix();
        double[][] projected = multiplyMatrix(projection, location);
        double[][] rotated = multiplyMatrix(rotationZ, projected);
        rotated = multiplyMatrix(rotationX,rotated);
        return rotated[1][0];
    }

    public double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2){
        double[][] result = new double[matrix1.length][matrix2[0].length];
        for(int i = 0; i < result.length; i ++){
            for(int j = 0; j < result[0].length; j++){
                double sum = 0;
                for(int k = 0; k < matrix2.length; k++){
                   sum += matrix1[i][k]*matrix2[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public void setXAngle(double xAngle){
        this.xAngle = xAngle;
    }

    public void setYAngle(double yAngle){
        this.yAngle = yAngle;
    }

    public void setZAngle(double zAngle){
        this.zAngle = zAngle;
    }

    public double getXAngle() {
        return xAngle;
    }

    public double getYAngle() {
        return yAngle;
    }

    public double getZAngle() {
        return zAngle;
    }
}
