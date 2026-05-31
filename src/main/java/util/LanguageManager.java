package util;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class LanguageManager {

    private static final ObjectProperty<Locale> currentLocale =
                new SimpleObjectProperty<>(
                        new Locale("sq")
                );
    private static ResourceBundle bundle;

    static{
        loadBundle(currentLocale.get());
    }

    private static void loadBundle(Locale locale){
        try{
            bundle = 
                    ResourceBundle.getBundle(
                        "lang.messages",
                        locale
                    );
        } catch(Exception e){

            System.err.println(
                "Gabim gjatë ngarkimit të gjuhës: "
                        + e.getMessage()
            );

            bundle = 
                    ResourceBundle.getBundle(
                         "lang.messages",
                         Locale.ENGLISH
                        );
        }
    }

    public static void setLanguage(String languangeCode){
        Locale newLocale =  new Locale(languangeCode);

        currentLocale.set(
            newLocale
        );

        loadBundle(newLocale);
    }
    
    public static String getText(String key){
        if(bundle != null && bundle.containsKey(key)){
            return bundle.getString(key);
        }
        return "[" + key + "]";
    }

    public static ObjectProperty<Locale>
    currentLocaleProperty(){
        return currentLocale;
    }
}