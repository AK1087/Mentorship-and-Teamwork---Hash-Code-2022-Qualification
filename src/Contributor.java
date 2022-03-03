import java.util.LinkedList;

public class Contributor
{
	private String name;
	private LinkedList<Skill> skills;
	private boolean isWorking;

	public Contributor(String name)
	{
		this.name = name;
		this.skills = new LinkedList<>();
	}
	
	public void improveSkill(Skill skill) 
	{
		for(Skill sk : skills) 
		{
			if(sk.getName().equals(skill.getName()) && skill.getLevel() <= sk.getLevel()) 
			{
				sk.setLevel(sk.getLevel() + 1);
				return;
			}
		}
	}
	
	public int getSkillLevel(String skillName) 
	{
		for(Skill skill : skills) 
		{
			if(skill.getName().equals(skillName)) 
			{
				return skill.getLevel();
			}
		}
		
		return -2;
	}

	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void addSkill(Skill skill) 
	{
		this.skills.add(skill);
	}

	public boolean isWorking()
	{
		return isWorking;
	}

	public void setWorking(boolean isWorking)
	{
		this.isWorking = isWorking;
	}
	
	public boolean canDo(Skill skill, LinkedList<Contributor> list, boolean isConfirmed) 
	{
		for(Skill sk : skills) 
		{
			if(sk.getName().equals(skill.getName()) && sk.getLevel() >= skill.getLevel())
			{
				list.add(this);
				return true;
			}
		}
		
		if(isConfirmed)
		{
			return true;
		}
		
		return false;
	}
}
