import java.io.File;
import java.util.Scanner;

public class FileReader
{
	public static Company parseTextFile(String fileName)
	{
		Company company = new Company();
		
		Scanner file = null;
		try
		{
			file = new Scanner(new File("C:\\Users\\zombi\\Downloads\\" + fileName), "UTF-8");
		} catch (Exception e)
		{
			System.out.println("File doesn't exist!");
		}

		if (file != null)
		{
			String[] line = file.nextLine().split("\\s+");
			int numberOfContributors = Integer.parseInt(line[0]); 
			int numberOfProjects = Integer.parseInt(line[1]); 

			for (int i = 0; i < numberOfContributors; i++)
			{
				line = file.nextLine().split("\\s+");

				String contributorName = line[0];
				int contributorSkillCount = Integer.parseInt(line[1]);
				
				Contributor cont = new Contributor(contributorName);

				for (int j = 0; j < contributorSkillCount; j++)
				{
					line = file.nextLine().split("\\s+");
					
					String skillNameContributor = line[0];
					int skillLevelContributor = Integer.parseInt(line[1]);
					
					cont.addSkill(new Skill(skillNameContributor, skillLevelContributor));
				}
				
				company.addContributor(cont);
			}
			
			for (int i = 0; i < numberOfProjects; i++) 
			{
				if(file.hasNext()) 
				{
					line = file.nextLine().split("\\s+");
					
					String projectName = line[0];
					int numberOfDaysToComplete = Integer.parseInt(line[1]);
					int scoreAwarded = Integer.parseInt(line[2]);
					int bestBefore = Integer.parseInt(line[3]);
					
					Project project = new Project(projectName, numberOfDaysToComplete, scoreAwarded, bestBefore);
					
					int numberOfRoles = Integer.parseInt(line[4]);
					
					for (int j = 0; j < numberOfRoles; j++)
					{
						line = file.nextLine().split("\\s+");
						
						String skillNameProject = line[0];
						int skillLevelProject = Integer.parseInt(line[1]);
						
						project.addNeededSkill(new Skill(skillNameProject, skillLevelProject));
					}
					
					company.addProject(project);
				}
			}

			file.close();
		}
		
		return company;
	}
}
