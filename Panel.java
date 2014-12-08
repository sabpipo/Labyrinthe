import java.awt.Color;
import java.awt.Font;	
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
public class Panel extends JPanel {
  	private Maze maze_;
  	// private int posX1;
  	// private int posY1;
  	private int posX;
  	private int posY;
  	private int block_size;

	public Panel(Maze maze){
		maze_ = maze;
		posX = maze.getCoordPukkaman()[1]*block_size*2+45;
		posY = maze.getCoordPukkaman()[0]*block_size*2+45;
		block_size = 25 - (maze.getMaze().size()/25);
		System.out.println(block_size);
	}


 	public void paintComponent(Graphics graph){
	    //Vous verrez cette phrase chaque fois que la méthode sera invoquée
	    graph.setColor(Color.WHITE);
	    graph.fillRect(0, 0, this.getWidth(), this.getHeight());
	    //this.setBackground(Color.BLACK);
	    graph.setColor(Color.WHITE);
	    // graph.fillOval(posX1, posY1, 10,10);
	    try{
	    	Image pakkuman = ImageIO.read(new File("pakkuman.png"));
	    	Image ghost = ImageIO.read(new File("ghost.png"));
	    	Image candy = ImageIO.read(new File("candy.png"));
	    	//graph.drawImage(pakkuman,posX, posY, 10,10, this);
	    	graph.setColor(Color.BLACK);
	    	graph.fillOval(posX, posY, 10,10);
	    	//graph.drawImage(ghost, 37+50, 37, 25, 25, this);
	    	//graph.drawImage(candy, 37, 37+50, 25, 25, this);
		    //int x1 = this.getWidth()/4;
		    //int y1 = this.getHeight()/4;                      
		    //graph.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
		    //graph.drawRect(x1, y1, this.getWidth()/2, this.getHeight()/2);
		    //graph.fillRect(posX, posY, 50, 50);
		    for(int i = 0; i < maze_.getMaze().length;i++){
		    	for(int j = 0; j < maze_.getMaze()[0].length;j++){
		    		// IDEA DRAW LINES INSTEAD
		    		String value = maze_.OutputAnalyse(maze_.getMaze()[i][j],i/*+25*/,j/*+25*/);
		    		//System.out.println("value: "+value);
		    		/*if (value == "+") {
		    			//dessine un point
		    			//graph.drawLine(x1, y1, x2,y2);
	    				graph.drawLine(x*block_size+25, y*block_size+25, x*block_size+25, y*block_size+25);
		    		}else*/ if(value == "---"){
						graph.drawLine((j-1)*block_size+25,i*block_size+25, (j+1)*block_size+25,i*block_size+25);
		    		}else if (value == "|") {
		    			graph.drawLine(j*block_size+25,(i-1)*block_size+25, j*block_size+25,(i+1)*block_size+25);
		    		}else if (value == " B "){
		    			graph.drawImage(candy, (j-1)*block_size+37, (i-1)*block_size+37, 25, 25, this);
		    		}else if (value == " M ") {
		    			graph.drawImage(ghost, (j-1)*block_size+37, (i-1)*block_size+37, 25, 25, this);
		    		}
		    	}
		    }
		}catch(IOException e){
	    	System.err.println("Caught IOException in Panel: " + e.getMessage());
	    }

	    // changer les couleurs: 

	  	//Font font = new Font("Courier", Font.BOLD, 20);
	    //graph.setFont(font);
	    //graph.setColor(Color.red);  

	    //graph.drawString("B",this.getWidth()/2, this.getHeight()/2);

	    // Dessiner une image:
	    /*try{
	    	Image img = ImageIO.read(new File("vue_paradisiaque.37108.jpg"));
	    	graph.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    }catch(IOException e){
	    	System.err.println("Caught IOException in Panel: " + e.getMessage());
	    }*/
	    //graph.drawImage(Image img, int x, int y, Observer obs);

	    // Dessiner une animation



	}

	// public void setPosX1(int pos){
	// 	this.posX1 = pos;
	// }

	// public void setPosY1(int pos){
	// 	this.posY1 = pos;
	// }

	public int getPosX() {
	    return posX;
	}

	public void setPosX(int posX) {
	    this.posX = posX;
	}

	public int getPosY() {
	    return posY;
	}

	public void setPosY(int posY) {
	    this.posY = posY;
	}           
}