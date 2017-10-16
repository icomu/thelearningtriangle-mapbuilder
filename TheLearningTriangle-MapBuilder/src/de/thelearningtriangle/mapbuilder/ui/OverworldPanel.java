package de.thelearningtriangle.mapbuilder.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import de.thelearningtriangle.mapbuilder.core.KeyboardController;
import de.thelearningtriangle.mapbuilder.core.MouseController;

public class OverworldPanel extends JPanel
{

	private int[][] map;
	private boolean gridEnabled = false;
	private int windowSize;

	public OverworldPanel(int[][] map, int windowSize)
	{
		this.map = map;
		this.windowSize = windowSize;
		
		MouseController mouseController = new MouseController(this);
		
		this.addMouseListener(mouseController);
		this.addMouseMotionListener(mouseController);
		
	}

	public void paint(Graphics g)
	{
		super.paint(g);

		try
		{

			drawOverworld(g, map);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	private void drawOverworld(Graphics g, int[][] map)
	{

		for (int rowNumber = 0; rowNumber < map.length; rowNumber++)
		{
			for (int columnNumber = 0; columnNumber < map.length; columnNumber++)
			{
				
				switch (map[columnNumber][rowNumber])
				{
				case 1:
					g.setColor(Color.GRAY);
					break;
				case 2:
					g.setColor(Color.BLACK);
					break;
				case 3:
					g.setColor(Color.MAGENTA);
					break;
				case 4:
					g.setColor(Color.RED);
					break;
				case 5:
					g.setColor(Color.GREEN);
					break;
				case 9:
					g.setColor(Color.LIGHT_GRAY);
					break;
				default:
					break;
				}
				
				g.fillRect(rowNumber*windowSize/map.length, columnNumber*windowSize/map.length, windowSize/map.length, windowSize/map.length);
				
				if(gridEnabled){
					g.setColor(Color.WHITE);
					g.drawRect(rowNumber*windowSize/map.length, columnNumber*windowSize/map.length, windowSize/map.length, windowSize/map.length);
				}
				
			}
		}
	}

	public int[][] getMap()
	{
		return map;
	}

	public void setMap(int[][] map)
	{
		this.map = map;
	}
	
	public void setGridEnabled(boolean gridEnabled)
	{
		this.gridEnabled = gridEnabled;
		repaint();
	}

	public boolean isGridEnabled()
	{
		return gridEnabled;
	}

	public int getWindowSize()
	{
		return windowSize;
	}
}
