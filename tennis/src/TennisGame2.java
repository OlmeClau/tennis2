import main.java.TennisGame;
//las reglas de este juego se apegan a las ITF reglas del tenis de 2015
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;    
    public String player1Result = ""; //resultado literal del puntaje individual jugador1
    public String player2Result = "";//resultado literal del puntaje individual jugador2
    private String player1Name;
    private String player2Name;
    private String score = "";//resultado del puntaje en conjunto 

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void setScorePlayersEven()
    {
                
            if (player1Points==0)
                score = "Love";
            if (player1Points==1)
                score = "Fifteen";
            if (player1Points==2)
                score = "Thirty";
            score += "-All";
        
       
    }
public void setScoreLiteral(String player1Literal, String player2Literal)
{
	score = player1Literal + "-" + player2Literal;
}
  
public void setScoreSomePlayerWinningTheOtherZero(int playerNumber)
{
	
	if(playerNumber==1)
	{
		if (player1Points==1)
            player1Result = "Fifteen";
        if (player1Points==2)
            player1Result = "Thirty";
        if (player1Points==3)
            player1Result = "Forty";        
        player2Result = "Love";
	}
	if(playerNumber==2)
	{
		 if (player2Points==1)
             player2Result = "Fifteen";
         if (player2Points==2)
             player2Result = "Thirty";
         if (player2Points==3)
             player2Result = "Forty";         
         player1Result = "Love";
		
	}
	setScoreLiteral(player1Result, player2Result);
	
	
}
public void setScoreSomePlayerWinningUnder4(int playerNumber)
{
	if(playerNumber==1)
	{
		if (player1Points==2)
            player1Result="Thirty";
        if (player1Points==3)
            player1Result="Forty";
        if (player2Points==1)
            player2Result="Fifteen";
        if (player2Points==2)
            player2Result="Thirty";
	}
	if(playerNumber==2)
	{
		 if (player2Points==2)
             player2Result="Thirty";
         if (player2Points==3)
             player2Result="Forty";
         if (player1Points==1)
             player1Result="Fifteen";
         if (player1Points==2)
             player1Result="Thirty";
	}
	setScoreLiteral(player1Result, player2Result);
}

    
   
    public boolean hasDifferenceOfTwo(int pointsPlayer1, int pointsPlayer2)
    {
    	return((player1Points-player2Points)>=2)
    		
    	
    }

    public String getScore(){

        if (player1Points == player2Points && player1Points < 4)
        {
          setScorePlayersEven();
        }
         if (player1Points > 0 && player2Points==0)
         {
        	 setScoreSomePlayerWinningTheOtherZero(1);
         }
         if (player2Points > 0 && player1Points==0)
         {
        	 setScoreSomePlayerWinningTheOtherZero(2);  
         }
        if (player1Points>player2Points && player1Points < 4)
        {
        	setScoreSomePlayerWinningUnder4(1);
        }
        if (player2Points>player1Points && player2Points < 4)
        {
        	setScoreSomePlayerWinningUnder4(2);

        }
        if (player1Points==player2Points && player1Points>=3)
        {
            score = "Deuce";

        }     
       
        if (player1Points > player2Points && player2Points >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2Points > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
        
        if (player1Points>=4 && player2Points>=0 && hasDifferenceOfTwo( player1Points,  player2Points))
        {
            score = "Win for player1";
        }
        if (player2Points>=4 && player1Points>=0 && hasDifferenceOfTwo( player1Points,  player2Points))
        {
            score = "Win for player2";
        }
        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            addPointsP1();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            addPointsP2();
        }
            
    }
    
    public void addPointsP1(){
        player1Points++;
    }
    
    public void addPointsP2(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            addPointsP1();
        else
            addPointsP2();
    }
}