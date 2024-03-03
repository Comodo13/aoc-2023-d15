
public class Main {
    public static void main(String[] args) {
        FocusCalculator calculator = new FocusCalculator();
        String initSequence = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
        String[] instructions = initSequence.split(",");
        long totalFocusingPower = calculator.calculateFocus(instructions);
        System.out.println("Total focusing power is : " + totalFocusingPower);
    }
}