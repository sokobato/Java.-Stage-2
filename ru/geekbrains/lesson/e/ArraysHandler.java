package ru.geekbrains.lesson.e;

public class ArraysHandler {

    private float[] arr;

    public ArraysHandler(int size) {
        arr = new float[size];
        initializeArray();
    }

    public ArraysHandler(float[] arr, int srcPos, int destPos, int length) {
        clearArray(length);
        System.arraycopy(arr, srcPos, this.arr, destPos, length);
    }

    public ArraysHandler() {
        clearArray(0);
    }

    public void appendArray(float[] arr, int srcPos, int destPos, int length){
        System.arraycopy(arr, srcPos, this.arr, destPos, length);
    }

    public void clearArray(int size){
        arr = new float[size];
    }


    private void initializeArray(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
    }

    public void calculateArrayValues(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public float[] getArr() {
        return arr;
    }
}
