package courses;

import database.*;
import java.util.*;
import java.util.regex.PatternSyntaxException;
/**
 *
 * @author Tommy
 */
public class Course {
    private String course_code;
    private String title;
    private String s_date;
    private String f_date;
    private String max_places;
    private String avail_places;
    private String total_fee;
    private String deposit;
    private String description;
    private String[] errors = new String[15];;
    private int errorCount; 
    DbManager dbmanager = new DbManager();
    
   public Course() {
        course_code = "";
        title = "";
        s_date = "";
        f_date = "";
        max_places = "";
        avail_places = "";
        total_fee = "";
        deposit = "";
        description = "";
        
    }

    
    public void setCourse_code(String value) {
        course_code = value;
    }
    
    public void setTitle(String value) {
        title = value;
    }
    
    public void setS_date(String value) {
        s_date = value;
    }
    
    public void setF_date(String value) {
        f_date = value;
    }
    
    public void setMax_places(String value) {
        max_places = value;
    }
    
    public void setAvail_places(String value) {
        avail_places = value;
    }
    
    public void setTotal_fee(String value) {
        total_fee = value;
    }
    
    public void setDeposit(String value) {
        deposit = value;
    }
    
    public void setDescription(String value) {
        description = value;
    }
    
    public String getCourse_code() {
        return course_code;  
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getS_date() {
        return s_date;
    }
    
    public String getF_date() {
        return f_date;
    }
    
    public String getMax_places() {
        return max_places;
    }
    
    public String getAvail_places() {
        return avail_places;
    }
    
    public String getTotal_fee() {
        return total_fee;
    }
    public String getDeposit() {
        return deposit;
    }
    
    public String getDescription() {
        return description;
    }
    
    /**
     * Checks to see a given string contains only numbers.
     * 
     * @param string the string to be checked.
     * @return true if a string has only number, false otherwise.
     */
    public boolean isInt(String string) {
        boolean result;
        
        try {
            int i = Integer.parseInt(string);
            result = true;
        }
        catch (NumberFormatException e) {
            result = false;
        }
        
        return result;
    }
    
    /**
     * checks to see if a given string is in the right date format 
     * 
     * @param string the string to be checked
     * @return true if the string in the the right format, false otherwise.
     */
    public boolean isDate(String string) {
        boolean result = true;
        String[] splits;
        String delim = "-";
        if(string.contains("/")) {
            delim = "/";
        }
        
        try {
            splits = string.split(delim);
            
            if(splits.length == 3 && splits[0].length() == 4 
                                 && splits[1].length() == 2
                                 && splits[2].length() == 2) {
                    for(String i: splits) {
                    if(!isInt(i)){
                        result = false;
                    }
                }
            }
            else {
                result = false;
            }
        }
        catch(PatternSyntaxException e) {
            result = false;
        }
        
        return result;
    }
    
    /**
     * Checks if data is valid for being entered into the database.
     * 
     * @return true if data is valid, false otherwise 
     */
    public boolean isValid() {
        Arrays.fill(errors, null);
        errorCount = 0;
        
        if(course_code.equals("")) {
            errors[errorCount] = "You must enter a course code";
            errorCount++;
        }
        
        else {
            course_code = course_code.toUpperCase();
        }
        
        if(title.equals("")) {
            errors[errorCount] = "You must enter a title for the course";
            errorCount++;
        }
        
        if(s_date.equals("")) {
            errors[errorCount] = "You must enter a starting date for the course";
            errorCount++;
        }
        else if(!isDate(s_date)) {
            errors[errorCount] = "The starting date nust be the correct format "
                               + "(YYYY-MM-DD)";
            errorCount++;
        }
        
        if(f_date.equals("")) {
            errors[errorCount] = "You must enter a finishing date for the course";
            errorCount++;
        }
        else if(!isDate(f_date)) {
            errors[errorCount] = "The finishing date nust be the correct format "
                               + "(YYYY-MM-DD)";
            errorCount++;
        }
        
        if(max_places.equals("")) {
            errors[errorCount] = "You must enter a the maximum places available for the course";
            errorCount++;
        } 
        else if(!isInt(max_places)) {

            errors[errorCount] = "You must enter a number for maximum places";
            errorCount++;    
            
        }
        
        if(total_fee.equals("")) {
            errors[errorCount] = "You must enter a fee for the course";
            errorCount++;
        } 
        else if(!isInt(total_fee)) {

            errors[errorCount] = "You must enter a number for total fee";
            errorCount++;    
            
        }
        
        if(deposit.equals("")) {
            errors[errorCount] = "You must enter a deposit for the course";
            errorCount++;
        } 
        else if(!isInt(deposit)) {

            errors[errorCount] = "You must enter a number for the deposit";
            errorCount++;    
            
        }
        
        if(description.equals("")) {
            errors[errorCount] = "You must enter a description for the course";
            errorCount++;
        }
         
        return errorCount == 0 ? true : false;
    }
    
    /**
     * Returns the number of errors from validating.
     * 
     * @return the number of errors. 
     */
    public int getErrorCount () {
        return errorCount;
    }
    
    /**
     * Returns an array containing all the errors from validating
     * 
     * @return  the array containing the errors
     */
    public String[] getErrors() {
        return errors;
    }
    
    /**
     * Adds the course to the database
     */
    public void addCourse() {
        dbmanager.connect();
        dbmanager.update("INSERT INTO courses " +
                         "VALUES ('" + course_code + "', '" 
                                    + title + "', '" 
                                    + s_date + "', '" 
                                    + f_date + "', " 
                                    + max_places + ", " 
                                    + max_places + ", " // avail_places should be same as max_places when first inserted
                                    + total_fee + ", " 
                                    + deposit + ", '" 
                                    + description + "')"); 
        dbmanager.disconnect();
    }
}

