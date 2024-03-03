import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FocusCalculator {

    public long calculateFocus(String[] instructions) {
        Map<Integer, List<Lens>> boxes = new HashMap<>();

        for (String instruction : instructions) {
            String label = instruction.split("[=-]")[0];
            char operation = instruction.charAt(label.length());
            int boxId = hashFunction(label);

            boxes.putIfAbsent(boxId, new ArrayList<>());
            List<Lens> box = boxes.get(boxId);

            if (operation == '=') {
                int focalLength = Integer.parseInt(instruction.substring(label.length() + 1));
                Lens newLens = new Lens(label, focalLength);

                boolean lensFound = false;
                for (Lens lens : box) {
                    if (lens.getLabel().equals(label)) {
                        lens.setFocalLength(focalLength); // Rewrite focal length if lens was found in the box
                        lensFound = true;                 // to save the right order
                        break;
                    }
                }

                // If lens wasn't found, add the new lens to the end of the box
                if (!lensFound) {
                    box.addLast(newLens);
                }
            }

            if (operation == '-') {
                box.remove(new Lens(label, 0));
            }
        }

        long totalFocusingPower = 0;
        for (Map.Entry<Integer, List<Lens>> boxEntry : boxes.entrySet()) {
            int boxId = boxEntry.getKey() + 1;
            List<Lens> box = boxEntry.getValue();
            for (int i = 0; i < box.size(); i++) {
                Lens lens = box.get(i);
                totalFocusingPower += (long) boxId * (i + 1) * lens.focalLength;
            }
        }
        return totalFocusingPower;
    }

    public static int hashFunction(String input) {
        int hashValue = 0;
        for (char c : input.toCharArray()) {
            hashValue += c;
            hashValue *= 17;
            hashValue %= 256;
        }
        return hashValue;
    }
}
