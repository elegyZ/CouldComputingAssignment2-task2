package assignment2;

public class Wolf {
	
	private String question;
	private String answer;
	
	public void initWolf(String question, String answer)
	{
		this.question = question;
		this.answer = answer;
	}
	
	public void setQuestion(String question)
	{
		this.question = question;
	}
	
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public String getAnswer()
	{
		return answer;
	}
}
