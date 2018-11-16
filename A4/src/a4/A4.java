/*
    I, Hemangi Bhavsar, 000767205 certify that this material is my original work. No other person's work has been used without due acknowledgement.

By: Hemangi Bhavsar
Date: Nov 14,2018

2. Names representing packages should be in all lower case.
4. Variable names must be in mixed case starting with lower case.
6. Names representing methods must contain a verb and written in mixed case starting with lower case.
10. All names should be written in English.
11. Variables with a large scope should have long names, variables with a small scope can have short names.
12. The name of the object is implicit, and should be avoided in a method name.
14. is prefix should be used for boolean variables and methods.
15. The term compute can be used in methods where something is computed.
19. Plural form should be used on names representing a collection of objects.
20. n prefix should be used for variables representing a number of objects.
22. Iterator variables should be called i, j, k etc.
24. Abbreviations in names should be avoided.
31. Functions (methods returning an object) should be named after what they return and procedures (void methods) after what they do.
32. Java source files should have the extension .java.
33. Classes should be declared in individual files with the file name matching the class name. Secondary private classes can be declared as inner classes 
    and reside in the file of the class they belong to.
34. File content should be kept within 80 columns.
35. Special characters like TAB and page break must be avoided.
37. The package statement must be the first statement of the file. All files should belong to a specific package.
38. The import statements must follow the package statement. import statements should be sorted with the most fundamental packages first, and grouped with 
    associated packages together and one blank line between groups.
39. Imported classes should always be listed explicitly.
40. Class and Interface declarations should be organized in the following manner:
41. Method modifiers should be given in the following order:
    <access> static abstract synchronized <unusual> final native
    The <access> modifier (if present) must be the first modifier.
44. Variables should be initialized where they are declared and they should be declared in the smallest scope possible.
45. Variables must never have dual meaning.
48. Variables should be kept alive for as short a time as possible.
49. Only loop control statements must be included in the for() construction.
50. Loop variables should be initialized immediately before the loop.
51. The use of do-while loops can be avoided.
55. The conditional should be put on a separate line.
58. Floating point constants should always be written with decimal point and at least one decimal.
59. Floating point constants should always be written with a digit before the decimal point.
66. The for statement should have the following form:
    for (initialization; condition; update) {
        statements;
    }
72. Single statement if-else, for or while statements can be written without brackets.
73.
    - Operators should be surrounded by a space character. 
    - Java reserved words should be followed by a white space. 
    - Commas should be followed by a white space. 
    - Colons should be surrounded by white space. 
    - Semicolons in for statements should be followed by a space character.
77. Variables in declarations can be left aligned.
80. All comments should be written in English.
82. There should be a space after the comment identifier.
84. Comments should be indented relative to their position in the code.
 */
package a4;

/**
 * Library of statistical functions using Generics for different statistical
 * calculations.
 *
 * see http://www.calculator.net/standard-deviation-calculator.html for sample
 * standard deviation calculations
 *
 * @author Hemangi bhavsar (000767205)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class A4 {

    /**
     * Return average value of arrayList data
     *
     * @param <T> define the type of the data in array list
     * @param nData list of all number which is send by main method
     * @param isPositiveNumber is just check positive value and give true and
     * false
     * @throws IllegalArgumentException If values are less 0
     * @return average of all list data
     */
    public static <T extends Number> double computeAverage(ArrayList<T> nData, boolean isPositiveNumber) {
        double sum = computeSum(nData, isPositiveNumber); // compute sum of list data by calling computeSum and store in sum variable
        int counter = 0; // initialize counter for check list data is positive or not 
        for (int i = 0; i < nData.size(); i++) {
            if (isPositiveNumber || nData.get(i).doubleValue() >= 0) // check value is positive or not
                counter++; // Increment of counter by 1 when data vlaue id positive
        }
        
        if (counter == 0) // check counter value is 0 or not
            throw new IllegalArgumentException("no values are > 0"); // throw IllegalArgumentException if counter is 0
        
        return sum / counter; // return average of all list data / total posotive number
    }

    /**
     * Return the sum of all data
     *
     * @param <T> define the type of the data in array list
     * @param nData list of all number which is send by main method
     * @param isPositiveNumber is just check positive value and give true and
     * false
     * @throws IllegalArgumentException If data is empty
     * @return sum of all list data
     */
    public static <T extends Number> double computeSum(ArrayList<T> nData, boolean isPositiveNumber) {
        if (nData.size() < 0) // check data size is less than 0
            throw new IllegalArgumentException("x cannot be empty"); // throw exception if data is empty

        double sum = 0.0; // initialze sum for store sum value in sum variable
        for (T TemporaryValue : nData) { // for loop for get all data of list 
            double value = TemporaryValue.doubleValue(); // convert integer value to double
            if (isPositiveNumber || value >= 0) // check isPositiveNumber and value is positive
                sum += value;  // increase sum value by adding value in sum 
        }

        return sum; // return double type sum result of list data
    }

    /**
     * Return the median of all data
     *
     * @param <T> define the type of the data in array list
     * @param nData list of all number which is send by main method
     * @throws IllegalArgumentException If size of array is less than 0
     * @return median of all list data
     */
    public static <T extends Number & Comparable> double computeMedian(ArrayList<T> nData) {
        if (nData.isEmpty()) // check data is empty or not
            throw new IllegalArgumentException("Size of array must be greater than 0"); // throw exception if data is empty

        Collections.sort(nData); // sort ndata in ascending order.

        double median = nData.get(nData.size() / 2).doubleValue(); // declare median varibale and store median value of nData list
        if (nData.size() % 2 == 0) // check nData size even or not
            median = (nData.get(nData.size() / 2).doubleValue() + nData.get(nData.size() / 2 - 1).doubleValue()) / 2; // if condition is true than median value is update according expression

        return median; //return double type median value of ndata list
    }

    /**
     * Return Standard Deviation value of all data
     *
     * @param <T> define the type of the data in array list
     * @param nData list of all number which is send by main method
     * @throws IllegalArgumentException If size of array is less than 0
     * @return Standard Deviation value of all list data
     */
    public static <T extends Number> double computeStandardDeviation(ArrayList<T> nData) {
        if (nData.size() <= 1) // check nData size is less than 1 or not
            throw new IllegalArgumentException("Size of array must be greater than 1"); // throw exception if data is less than 1

        int sizeOfNumbers = nData.size(); // declare size Of Numbers local variable to store value of nData list size
        double sum = 0.0; // declare and inisilize sum variable
        double average = computeAverage(nData, true); // compute average of nData by calling computeAverage method and store in average variable

        for (int i = 0; i < sizeOfNumbers; i++) { // for loop for get all data of list
            double valueInDouble = nData.get(i).doubleValue(); // convert each nData number to double type and store in valueInDouble variable
            sum += Math.pow(valueInDouble - average, 2); // increament value of sum by use function of math power
        }
        return Math.sqrt(sum / (sizeOfNumbers - 1)); // return double type standard Deviation value 
    }

    /**
     * This is the main method which makes use of test result of Mathematics
     * functions.
     *
     * @param args Unused.
     * @return Nothing.
     */
    // Simple set of tests that confirm that functions operate correctly
    public static void main(String[] args) {
        ArrayList<Integer> testDataInteger = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)); // An array of Integer data 
        ArrayList<Double> testDataDouble = new ArrayList<>(Arrays.asList(2.2, 3.3, 66.2, 17.5, 30.2, 31.1)); // An array of double data

        System.out.printf("The sum of the Integer array = %.0f\n", computeSum(testDataInteger, true)); // Print result of all Integer data's sum

        System.out.printf("The average of the Integer test set = %.0f\n", computeAverage(testDataInteger, true)); // Print result of all Integer data's Average
        System.out.printf("The average of the Double test set = %.2f\n", computeAverage(testDataDouble, true)); // Print result of all Double data's Average

        System.out.printf("The median value of the Integer data set = %.1f\n", computeMedian(testDataInteger)); // Print result of all Integer data's Median
        System.out.printf("The median value of the Double data set = %.1f\n", computeMedian(testDataDouble)); // Print result of all Double data's Median

        System.out.printf("The sample standard deviation of the Integer test set = %.2f\n", computeStandardDeviation(testDataInteger)); // Print result of all Integer data's Standard Deviation
        System.out.printf("The sample standard deviation of the Double test set = %.2f\n", computeStandardDeviation(testDataDouble)); // Print result of all Double data's Standard Deviation
    }
}
