package pattern;

import java.awt.Graphics;

import utils.LayoutConstants;

@SuppressWarnings("serial")
public class PieChartObserver extends ChartObserver{

	public PieChartObserver(CourseData data) {
		super(data);
	}
	
	public void paint(Graphics g, Integer[] data) {
		super.paint(g);
		int radius = 100;
		
		//first compute the total number of students
		double total = 0.0;
		for (int i = 0; i < data.length; i++) {
			total += data[i];
		}
		//if total == 0 nothing to draw
		if (total != 0) {
			double startAngle = 0.0;
			for (int i = 0; i < data.length; i++) {
				double ratio = (data[i] / total) * 360.0;
				//draw the arc
				g.setColor(LayoutConstants.subjectColors[i%LayoutConstants.subjectColors.length]);
				g.fillArc(LayoutConstants.xOffset, LayoutConstants.yOffset + 300, 2 * radius, 2 * radius, (int) startAngle, (int) ratio);
				startAngle += ratio;
			}
		}
	}

}
