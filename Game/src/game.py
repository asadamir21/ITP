import random


class Game:
    def __init__(self, newPlayerName):
        self.playerName = newPlayerName
        self.playerHand = "NA"
        self.botHand = "NA"
        self.winner = "No winner yet"
        

    def runGame(self):
        if ((self.playerHand == 'rock' or self.playerHand == 'Rock') and self.botHand == 1):
            self.winner = 'You win'
        elif ((self.playerHand == 'rock' or self.playerHand == 'Rock') and self.botHand == 2):
            self.winner = 'You tie.'
        elif ((self.playerHand == 'rock' or self.playerHand == 'Rock') and self.botHand == 3):
            self.winner = 'You lose.'
        elif ((self.playerHand == 'paper' or self.playerHand == 'Paper') and self.botHand == 1):
            self.winner = 'You lose.'
        elif ((self.playerHand == 'paper' or self.playerHand == 'Paper') and self.botHand == 2):
            self.winner = 'You win!'
        elif ((self.playerHand == 'paper' or self.playerHand == 'Paper') and self.botHand == 3):
            self.winner = 'You tie.'
        elif ((self.playerHand == 'scissors' or self.playerHand == 'Scissors') and self.botHand == 1):
            self.winner = 'You tie.'
        elif ((self.playerHand == 'scissors' or self.playerHand == 'Scissors') and self.botHand == 2):
            self.winner = 'You lose.'
        elif ((self.playerHand == 'scissors' or self.playerHand == 'Scissors') and self.botHand == 3):
            self.winner = 'You win!'
        else:
            self.winner = 'INVALID input, try again'

def main():
    
    print("Enter Your Name")
    myGame = Game(input())
    
    print("\n")
    
    print("Enter Your move")
    print("1 for Rock")
    print("2 for Paper")
    print("3 for Scissors")
    
    print("\n")   
    
    Ind = False
        
    while not Ind:
        try:
            X = int(input())

            if(X == 1):
                myGame.playerHand = "Rock"
                    
            elif(X == 2):
                myGame.playerHand = "Paper"
            
            elif(X == 3):
                myGame.playerHand = "Scissors"
            
            else:
                raise Exception("Enter valid Input")
                
            Ind = True;
                    
        except:
            print("invalid input")     
    
    print("\n")
    
    myGame.botHand = random.randint(1,3)        
    
            
        
    print("\n")
    print("Player Name:     " + myGame.playerName)
    print("Your Move:    " + myGame.playerHand)
    
    if(myGame.botHand == 1):
        print("Opponent Move:     Scissors")
    
    elif(myGame.botHand == 2):
            print("Opponent Move:     Rock")
            
    elif(myGame.playerHand == 3):
            print("Opponent Move:     Paper")
            
     
    myGame.runGame()
             
    print(myGame.winner)


main()