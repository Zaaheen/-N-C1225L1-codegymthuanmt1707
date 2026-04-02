    package ss6_Inheritance.Point;

    public class Point3D extends Point2D {
        private float z = 0.0f;

        public Point3D(float x, float y, float z) {
            super(x, y);
            this.z = z;
        }

        public Point3D() {
        }

        public float getZ() {
            return z;
        }

        public void setZ(float z) {
            this.z = z;
        }

        public float[] getXYZ(){
//            float[] location = new float[3];
//            location[0] = getX();
//            location[1] = getY();
//            location[2] = this.z;
//            return location;
            return new float[]{getX(), getY(), z};
        }
        public void setXYZ(float x, float y, float z){
            setX(x);
            setY(y);
            this.z = z;
        }

        @Override
        public String toString() {
            return "Point3D{" +
                    "x=" + getX() +
                    ", y=" + getY() +
                    ", z=" + z +
                    '}';
        }
    }
