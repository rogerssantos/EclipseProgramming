
public class GradeBookOneFile {

	private String courseName;
				
		public void setCourseName( String name )
		{
			courseName = name;
		}
		
		public String getCourseName()
		{
			return courseName;
		}
		
		public void displayMessage()
		{
			System.out.printf( "Welcome to he grade book for\n%s!\n",
					getCourseName() );
		}

}