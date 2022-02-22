 package application;

import java.beans.PropertyChangeSupport;

public class JavaBean {
		private String name;
		
		private PropertyChangeSupport support = new PropertyChangeSupport(this);
		public void setName(String name) {
		support.firePropertyChange("name", this.name, this.name = name);
		}
		public String getName() {
		return this.name;
		
		}
		}

