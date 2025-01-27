package dev.labs.s3;

public class Arguments {

    public static void main(String[] args) {
        Arguments testInt = new Arguments();
        int passInMain = 6;
        testInt.primitiveDataType(passInMain); // Passed in by value
        System.out.println(passInMain + " set in main" +"\n");

        String passedInMain = "The argument";
        testInt.referenceDataTypes(passedInMain);
        System.out.println(passedInMain +"\n");

        int originOneMain = 10;
        int originTwoMain = 10;
        Circle myCircle = new Circle(originOneMain, originTwoMain);
        System.out.println("Passed in arguments for originOne is " + originOneMain + ", and originTwo is "+ originTwoMain);
        myCircle.moveCircle(myCircle, 5, 5);
        System.out.println("originOne change persisted as " + myCircle.getOriginOne() + " and originTwo changes persisted as " + myCircle.getOriginTwo() +"\n");
    }

    void primitiveDataType(int passedInTheMethod){
        System.out.println(passedInTheMethod + " is the argument");
        passedInTheMethod = 10; // Value changes are only within the scope of the method
        System.out.println(passedInTheMethod + " reassigned in method");
    }

    void referenceDataTypes(String passIn){
        System.out.println(passIn);
        passIn = "Passed in method";
        System.out.println(passIn);
    }

}

// Ref: https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html
class Circle{
    public Circle(int originOne, int originTwo){
        this.originOne = originOne;
        this.originTwo = originTwo;
    }

    public int getOriginOne() {
        return originOne;
    }

    public void setOriginOne(int originOne) {
        this.originOne = originOne;
    }

    public int getOriginTwo() {
        return originTwo;
    }

    public void setOriginTwo(int originTwo) {
        this.originTwo = originTwo;
    }

    private int originOne;
    private int originTwo;

    public void moveCircle(Circle circle, int originOne, int originTwo) {
        // code to move origin of circle to x+deltaX, originTwo+deltaY
        System.out.println("moveCircle passed in arguments for originOne is "+originOne + ", and originTwo is "+originTwo);
        circle.setOriginOne(circle.getOriginOne() + originOne); // persist even when method returns
        circle.setOriginTwo(circle.getOriginTwo() + originTwo); // persists even when method returns
        System.out.println("Updated originOne is "+circle.getOriginOne() + ", and originTwo is "+circle.getOriginTwo());

        // code to assign a new reference to circle - won't persist
        circle = new Circle(0, 0); // Passed in by value does not persist
        System.out.println("originOne reassigned in the method as " + circle.getOriginOne() + ", and originTwo as " + circle.getOriginTwo());
    }
}
