package edu.pdx.cs410J.jfeng;

import edu.pdx.cs410J.lang.Human;

import java.util.ArrayList;
import java.util.Objects;

/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */



public class Student extends Human {

  /**
   * Creates a new <code>Student</code>
   *
   * @param name
   *        The student's name
   * @param classes
   *        The names of the classes the student is taking.  A student
   *        may take zero or more classes.
   * @param gpa
   *        The student's grade point average
   * @param gender
   *        The student's gender ("male", "female", or "other", case insensitive)
   */

  private final ArrayList<String> classes;
  public Student(String name, ArrayList<String> classes, double gpa, String gender) {
    super(name);

    validateNotNull(name);
    validateNotNull(classes);
    validateNotNull(gender);

    this.classes = classes;
  }

  private static void validateNotNull(Object obj) {
    if(obj == null)
    {
      throw new NullPointerException();
    }
  }

  /**
   * All students say "This class is too much work"
   */
  @Override
  public String says() {
    return "This class is to much work!";
  }

  /**
   * Returns a <code>String</code> that describes this
   * <code>Student</code>.
   */
  public String toString() {
    //throw new UnsupportedOperationException("Not implemented yet");

    int NumberOfClasses = getNumberOfClasses();

    return "is taking " + NumberOfClasses + " classes";
  }

  private static int getNumberOfClasses()
  {
    return 1;
  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the student to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args)
  {
    System.err.println("Missing command line arguments");
  }
}