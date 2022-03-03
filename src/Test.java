public class Test
{
	public static void main(String[] args)
	{
		greedyApproach();
	}
	
	public static void greedyApproach() 
	{
		Company company = FileReader.parseTextFile("b_better_start_small.in.txt");

		company.simulateProjects();
	}
}
