import javax.swing.JOptionPane;
import java.util.Map;
import java.util.HashMap;

public class Converter {
    public void menu(){
        String[] convertOptions = {
            "currency"
        };

        int selectedConverter = JOptionPane.showOptionDialog(null, "What do you want to convert?", "Select Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, convertOptions, convertOptions[0]);

        switch (selectedConverter){
            case 0:
                currency();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Selected Option Invalid!");
                break;
        }

    }

    public int closeMenu(){
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Yes", JOptionPane.YES_NO_CANCEL_OPTION);

        switch(choice){
            case JOptionPane.YES_OPTION:
                return 1;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "Finished Program");
                return -1;
            case JOptionPane.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Completed Program");
                return -1;
            default:
                return 0;
        }
    }

    public static void currency(){

        String[] currencyOptions = new String[5];

        currencyOptions[0] = "Brazilian Real";
        currencyOptions[1] = "US Dollar";
        currencyOptions[2] = "British Pound";
        currencyOptions[3] = "Argentine Peso";
        currencyOptions[4] = "Chilean Peso";

        Map<String, String> currencyDict = new HashMap<>();
        
        currencyDict.put(currencyOptions[0], "BRL");
        currencyDict.put(currencyOptions[1], "USD");
        currencyDict.put(currencyOptions[2], "GBP");
        currencyDict.put(currencyOptions[3], "ARS");
        currencyDict.put(currencyOptions[4], "CLP");

        int origin = JOptionPane.showOptionDialog(null, "Choose your origin currency", "Select Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, currencyOptions, currencyOptions[0]);
        int destination = -1;
        
        do{
            destination = JOptionPane.showOptionDialog(null, "Choose your destination currency", "Select Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, currencyOptions, currencyOptions[0]);
        }while(origin == destination);

        float value = Float.parseFloat(JOptionPane.showInputDialog(null, "Value:"));

        convertCurrency(currencyDict.get(currencyOptions[origin]), currencyDict.get(currencyOptions[destination]), value);
    
    
    }

    public static void convertCurrency(String origin, String destination, float value){
        switch(origin){
            case "BRL":
                convertBRL(destination, value);
                break;
            case "USD":
                convertUSD(destination, value);
                break;
            case "GBP":
                convertGBP(destination, value);
                break;
            case "ARS":
                convertARS(destination, value);
                break;
            case "CLP":
                convertCLP(destination, value);
                break;
            default:
                break;
        }

    }

    public static void convertBRL(String destination, float value){
        float para = 0.0f, result = 0.0f;
        switch(destination){
            case "USD":
                para = 0.19f;
                result = calculateConverter(value, para);
                break;
            case "GBP":
                para = 0.16f;
                result = calculateConverter(value, para);
                break;
            case "ARS":
                para = 38.85f;
                result = calculateConverter(value, para);
                break;
            case "CLP":
                para = 157.38f;
                result = calculateConverter(value, para);
                break;
            default:
                break;
        }
        
        JOptionPane.showMessageDialog(null, result);
    }

    public static void convertUSD(String destination, float value){
        float para = 0.0f, result = 0.0f;
        switch(destination){
            case "BRL":
                para = 5.25f;
                result = calculateConverter(value, para);
                break;
            case "GBP":
                para = 0.82f;
                result = calculateConverter(value, para);
                break;
            case "ARS":
                para = 203.91f;
                result = calculateConverter(value, para);
                break;
            case "CLP":
                para = 825.88f;
                result = calculateConverter(value, para);
                break;
            default:
                break;
        }
        
        JOptionPane.showMessageDialog(null, result);
    }

    public static void convertGBP(String destination, float value){
        float para = 0.0f, result = 0.0f;
        switch(destination){
            case "BRL":
                para = 6.43f;
                result = calculateConverter(value, para);
                break;
            case "USD":
                para = 1.23f;
                result = calculateConverter(value, para);
                break;
            case "ARS":
                para = 249.91f;
                result = calculateConverter(value, para);
                break;
            case "CLP":
                para = 1012.20f;
                result = calculateConverter(value, para);
                break;
            default:
                break;
        }
        JOptionPane.showMessageDialog(null, result);
    }

    public static void convertARS(String destination, float value){
        float para = 0.0f, result = 0.0f;
        switch(destination){
            case "BRL":
                para = 0.03f;
                result = calculateConverter(value, para);
                break;
            case "USD":
                para = 0.0049f;
                result = calculateConverter(value, para);
                break;
            case "GBP":
                para = 0.0040f;
                result = calculateConverter(value, para);
                break;
            case "CLP":
                para = 4.05f;
                result = calculateConverter(value, para);
                break;
            default:
                break;
        }
        JOptionPane.showMessageDialog(null, result);
    }

    public static void convertCLP(String destination, float value){
        float para = 0.0f, result = 0.0f;
        switch(destination){
            case "BRL":
                para = 0.0064f;
                result = calculateConverter(value, para);
                break;
            case "USD":
                para = 0.0012f;
                result = calculateConverter(value, para);
                break;
            case "GBP":
                para = 0.000988f;
                result = calculateConverter(value, para);
                break;
            case "ARS":
                para = 0.25f;
                result = calculateConverter(value, para);
                break;
            default:
                break;
        }        
        JOptionPane.showMessageDialog(null, result);
    }

    public static float calculateConverter(float valueOrigin, float parameter){
        return valueOrigin * parameter;
    }


}
