import java.awt.Graphics;
import javax.swing.JPanel;

public class RecurtionPattern extends JPanel {

	private double PI = 3.14;
	int spikesCount = 3;
	int depth = 3;
	
	public void drawStar(Graphics g, double centerX, double centerY, double minorRadius, double majorRadius, int spikesCount) {
		int verticesCount = spikesCount * 2;
		for(int i = 1; i < verticesCount + 1; i++) {
			double oldRadius = ((i - 1) % 2 == 0) ? minorRadius : majorRadius;
			double newRadius = (i % 2 == 0) ? minorRadius : majorRadius;

			double oldPosX = centerX + Math.cos(((i - 1) / (double)verticesCount) * 2 * PI) * oldRadius;
			double oldPosY = centerY + Math.sin(((i - 1) / (double)verticesCount) * 2 * PI) * oldRadius;
			
			double posX = centerX + Math.cos(((i) / (double)verticesCount) * 2 * PI) * newRadius;
			double posY = centerY + Math.sin(((i) / (double)verticesCount) * 2 * PI) * newRadius;
			g.drawLine((int)oldPosX, (int)oldPosY, (int)posX, (int)posY);
		}
	}
	
	public void drawStarRecurcive(Graphics g,
			double centerX, double centerY, 
			double minorRadius, double majorRadius, 
			int spikesCount, int generationsCount) {
		drawStar(g, centerX, centerY, minorRadius, majorRadius,
				spikesCount);
		
		if(generationsCount > 1) {
			int verticesCount = spikesCount * 2;	
			for(int i = 0; i < verticesCount; i++) {
				if(i % 2 == 1) {
					double posX = centerX + Math.cos(((i) / (double)verticesCount) * 2 * PI) * majorRadius;
					double posY = centerY + Math.sin(((i) / (double)verticesCount) * 2 * PI) * majorRadius;
					drawStarRecurcive(g, posX, posY, minorRadius * 0.5, majorRadius * 0.5f,
							spikesCount, generationsCount - 1);
				}
			}
		}
	}
	
	public void drawRecurtion(Graphics g) {
		g.drawLine(0, 0, 100, 100);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		drawStarRecurcive(g, 140, 120, 25, 50, spikesCount, depth);
	}
}
