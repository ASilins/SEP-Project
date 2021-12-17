package Model;

import Utils.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentModelManager
{
  private String fileName;

  public StudentModelManager(String fileName)
  {
    this.fileName = fileName;
  }

  // Use the utils.MyFileHandler class to retrieve a model.StudentList object with all Students
  public StudentList getAllStudents()
  {
    StudentList allStudents = new StudentList();

    try
    {
      allStudents = (StudentList)MyFileHandler.readFromBinaryFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class Not Found");
    }
    return allStudents;
  }



  // Use the utils.MyFileHandler class to save all Students in the model.StudentList object
  public void saveStudents(StudentList students)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(fileName, students);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file");
    }
  }



}
