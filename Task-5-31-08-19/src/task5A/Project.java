package task5A;

public class Project {
	
	public int pCode;
	public String pTitle;
	public int duration;
	public String cName;
	
	public Project(int pCode, String pTitle, int duration, String cName) {
		super();
		this.pCode = pCode;
		this.pTitle = pTitle;
		this.duration = duration;
		this.cName = cName;
	}

	@Override
	public String toString() {
		return "Project [pCode=" + pCode + ", pTitle=" + pTitle + ", duration=" + duration + ", cName=" + cName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cName == null) ? 0 : cName.hashCode());
		result = prime * result + duration;
		result = prime * result + pCode;
		result = prime * result + ((pTitle == null) ? 0 : pTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (cName == null) {
			if (other.cName != null)
				return false;
		} else if (!cName.equals(other.cName))
			return false;
		if (duration != other.duration)
			return false;
		if (pCode != other.pCode)
			return false;
		if (pTitle == null) {
			if (other.pTitle != null)
				return false;
		} else if (!pTitle.equals(other.pTitle))
			return false;
		return true;
	}
	
	

}
