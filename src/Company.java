import java.util.LinkedList;

public class Company
{
	private LinkedList<Contributor> contributors;
	private LinkedList<Project> projects;
	private int dayCounter = 0;
	private int projectCount = 0;
	
	public Company()
	{
		contributors = new LinkedList<>();
		projects = new LinkedList<>();
	}
	
	public void addContributor(Contributor contributor) 
	{
		contributors.add(contributor);
	}
	
	public void addProject(Project project) 
	{
		projects.add(project);
	}

	public LinkedList<Contributor> getContributors()
	{
		return contributors;
	}

	public void setContributors(LinkedList<Contributor> contributors)
	{
		this.contributors = contributors;
	}

	public LinkedList<Project> getProjects()
	{
		return projects;
	}

	public void setProjects(LinkedList<Project> projects)
	{
		this.projects = projects;
	}

	public void simulateProjects() 
	{
		LinkedList<Project> canDoneProjects = projectsThatCanBeFinished();
		
		System.out.println(canDoneProjects.size());

		for(Project project : canDoneProjects) 
		{
			System.out.println(project.getName());
			
			for(Contributor cont : project.contributorsThatDoProject)
			{
				System.out.print(cont.getName() + " ");
			}
			
			System.out.println();
		}
	}
	
	public LinkedList<Project> projectsThatCanBeFinished()
	{
		LinkedList<Project> projectsCanDone = new LinkedList<>();
		
		boolean canFinishProjectNow = false;
		
		for(Project proj : projects)
		{	
			LinkedList<Contributor> tempTeam = new LinkedList<>();

			for(Skill skill : proj.getSkillsNeeded()) 
			{	
				LinkedList<Contributor> peopleThatHaveSkill = new LinkedList<>();
				boolean skillConfirmed = false;
				
				for(Contributor cont : contributors) 
				{
					skillConfirmed = cont.canDo(skill, peopleThatHaveSkill, skillConfirmed);
				}
				
				if(!skillConfirmed) 
				{
					break;
				}		
				
				int minReq = 1000;
				Contributor who = null;
				
				for(Contributor cont : peopleThatHaveSkill) 
				{
					if(!cont.isWorking()) 
					{
						if(cont.getSkillLevel(skill.getName()) <= minReq) 
						{
							minReq = cont.getSkillLevel(skill.getName());
							who = cont;
						}
					}
				}
				
				if(who == null) 
				{
					System.out.println("ERROR!");
				}
				
				else 
				{
					tempTeam.add(who);
					who.setWorking(true);
				}
			}
			
			if(tempTeam.size() == proj.getSkillsNeeded().size()) 
			{
				for(Contributor cont : contributors) 
				{
					for(Contributor cont2 : tempTeam) 
					{
						if(cont != cont2) 
						{
							cont.setWorking(false);
						}
					}
				}
				
				proj.contributorsThatDoProject = tempTeam;
				
				projectsCanDone.add(proj);
			}
			
		
		}

		return projectsCanDone;
	}
}
