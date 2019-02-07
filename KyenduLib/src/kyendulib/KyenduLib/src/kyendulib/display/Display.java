package kyendulib.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private String title;
	private Canvas canvas;
	
	private int width;
	private int height;
	private int scale = 2;
	
	private boolean scaled = false;
	
	public Display(String title, int width, int height, Canvas canvas) {
		this.title = title;
		this.canvas = canvas;
		this.width = width;
		this.height = height;
	}
	
	public Display(String title, int width, int height, int scale, boolean scaled, Canvas canvas) {
		this.title = title;
		this.canvas = canvas;
		this.scaled = scaled;
		this.scale = scale;
		
		if(!scaled) {
			this.width = width;
			this.height = height;			
		}
		
		if(scaled) {
			this.width *= scale;
			this.height *= scale;
		}
		
	}
	
	public Display(String title, int width, int height, boolean scaled, Canvas canvas) {
		this.title = title;
		this.canvas = canvas;
		this.scaled = scaled;
		
		if(!scaled) {
			this.width = width;
			this.height = height;
		}
		
		if(scaled) {
			this.width *= scale;
			this.height *= scale;
		}
		
	}

	public Display createDisplay() {
		JFrame frame = new JFrame();
		frame.setTitle(title);
		
		if(scaled) {
			frame.setMinimumSize(new Dimension(width * scale, height * scale));
			frame.setMaximumSize(new Dimension(width * scale, height * scale));
			frame.setPreferredSize(new Dimension(width * scale, height * scale));	
		}
		
		if(!scaled) {
			frame.setMinimumSize(new Dimension(width, height));
			frame.setMaximumSize(new Dimension(width, height));
			frame.setPreferredSize(new Dimension(width, height));			
		}
		frame.pack();
		
		frame.add(canvas);
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return this;
	}
	
	public Display createDisplay(int scale) {
		this.scale = scale;
		JFrame frame = new JFrame();
		frame.setTitle(title);
		
		if(scaled) {
			frame.setMinimumSize(new Dimension(width * scale, height * scale));
			frame.setMaximumSize(new Dimension(width * scale, height * scale));
			frame.setPreferredSize(new Dimension(width * scale, height * scale));
		}
		
		if(!scaled) {
			frame.setMinimumSize(new Dimension(width, height));
			frame.setMaximumSize(new Dimension(width, height));
			frame.setPreferredSize(new Dimension(width, height));			
		}
		
		frame.pack();
		
		frame.add(canvas);
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return this;
	}
	
	public Display createDisplay(boolean scaled) {
		this.scaled = scaled;
		JFrame frame = new JFrame();
		frame.setTitle(title);
		
		if(scaled) {
			frame.setMinimumSize(new Dimension(width * scale, height * scale));
			frame.setMaximumSize(new Dimension(width * scale, height * scale));
			frame.setPreferredSize(new Dimension(width * scale, height * scale));
		}
		
		if(!scaled) {
			frame.setMinimumSize(new Dimension(width, height));
			frame.setMaximumSize(new Dimension(width, height));
			frame.setPreferredSize(new Dimension(width, height));			
		}
		
		frame.pack();
		
		frame.add(canvas);
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return this;
	}
	
	public Display createDisplay(boolean scaled, int scale) {
		this.scaled = scaled;
		this.scale = scale;
		JFrame frame = new JFrame();
		frame.setTitle(title);
		
		if(scaled) {
			frame.setMinimumSize(new Dimension(width * scale, height * scale));
			frame.setMaximumSize(new Dimension(width * scale, height * scale));
			frame.setPreferredSize(new Dimension(width * scale, height * scale));
		}
		
		if(!scaled) {
			frame.setMinimumSize(new Dimension(width, height));
			frame.setMaximumSize(new Dimension(width, height));
			frame.setPreferredSize(new Dimension(width, height));			
		}
		
		frame.pack();
		
		frame.add(canvas);
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return this;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getScaledWidth() {
		return width * scale;
	}


	public int getScaledHeight() {
		return height * scale;
	}


	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public boolean isScaled() {
		return scaled;
	}

	public void setScaled(boolean scaled) {
		this.scaled = scaled;
	}
	
}