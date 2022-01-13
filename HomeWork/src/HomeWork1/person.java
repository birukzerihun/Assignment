

package HomeWork1;



public class person {
    private String SID;
     private String studId;
      private   String Firstname;
  private   String Lastname;
  private   String Section ;
  private   String Department;
    public person()
    {
    this.SID="";
   this.studId = "";
    this.Firstname = "";
    this.Lastname = "";
    this.Section = "";
    this.Department = "";
    }
  public person(String SID,String studId,String Firstname)
          {
                     
  this.SID=SID;
  this.studId = studId;
  this.Firstname = Firstname;
          
}
  public String getSID(){
  return SID;
  }

public void setSID(String SID)
{
 this.SID = SID;
}
  public String getstudId(){
  return studId;
  }

public void setstudId(String studId)
{
 this.studId = studId;
}
 public String getFirstname(){
  return Firstname;
  }

public void setFirstname(String studId)
{
 this.Firstname = Firstname;
}

public String getLastname(){
  return Lastname;
  }

public void setLastnamee(String studId)
{
 this.Lastname = Lastname;
}


public String getSection(){
  return Section;
  }

public void setSection(String studId)
{
 this.Section = Section;
}
public String getDepartment()
{
  return Department;
  }

public void setDepartment(String studId)
{
 this.Department = Department;
}

    void setLastname(String newValue) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}