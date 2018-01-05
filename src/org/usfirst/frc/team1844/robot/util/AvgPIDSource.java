package org.usfirst.frc.team1844.robot.util;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 * A simple implementation of the {@link PIDSource} that takes the average of
 * two {@code PIDSource} objects, and simply returns the average value of the
 * two. This is useful for some applications, such as certain implementations of
 * PID to drive a specific distance, using both the left and right encoders to
 * feed a single closed-loop controller.
 * 
 * Created by Team 4946
 */
public class AvgPIDSource implements PIDSource {

	private PIDSource m_sourceA;
	private PIDSource m_sourceB;

	public AvgPIDSource(PIDSource a, PIDSource b) {
		m_sourceA = a;
		m_sourceB = b;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		m_sourceA.setPIDSourceType(pidSource);
		m_sourceB.setPIDSourceType(pidSource);
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return m_sourceA.getPIDSourceType();
	}

	@Override
	public double pidGet() {
		return (m_sourceA.pidGet() + m_sourceB.pidGet()) / 2.0;
	}

}
