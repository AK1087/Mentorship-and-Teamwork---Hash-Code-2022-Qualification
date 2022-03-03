import java.util.LinkedList;

public class Project
{
	private String name;
	private int duration;
	private int score;
	private int bestBefore;
	
	private LinkedList<Skill> skillsNeeded;
	public LinkedList<Contributor> contributorsThatDoProject;
	
	private boolean canStart = false;

	public Project(String name, int duration, int score, int bestBefore)
	{
		this.name = name;
		this.duration = duration;
		this.score = score;
		this.bestBefore = bestBefore;
		
		this.skillsNeeded = new LinkedList<>();
		this.contributorsThatDoProject = new LinkedList<>();
	}
	
	public LinkedList<Skill> getSkillsNeeded()
	{
		return skillsNeeded;
	}

	public void setSkillsNeeded(LinkedList<Skill> skillsNeeded)
	{
		this.skillsNeeded = skillsNeeded;
	}

	public void addNeededSkill(Skill skill) 
	{
		skillsNeeded.add(skill);
	}

	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public void setDuration(int duration)
	{
		this.duration = duration;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public int getBestBefore()
	{
		return bestBefore;
	}
	
	public void setBestBefore(int bestBefore)
	{
		this.bestBefore = bestBefore;
	}
	
	public void checkIfCanStart() 
	{
		canStart = skillsNeeded.size() == 0;
	}
	
	
}
