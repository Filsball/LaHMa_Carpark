//package U02;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class SortableImpl implements Sortable {
	
	private Set<String[]> tasks;
	private Set<String> allTasks;
	
	public SortableImpl(String[][] tasks) {
		allTasks = new HashSet<String>();
		this.tasks = new HashSet<String[]>();
		if(tasks.length > 0) {
			for(int i = 0; i<tasks.length; i++) {
				for(int j = 0; j<tasks[0].length; j++) {
					allTasks.add(tasks[i][j]);
					this.tasks.add(tasks[i]);
				}
			}			
		}		
	}
	
	public Set<String> possibleTasks(){
		Set<String> possible = allTasks;
		Iterator<String[]> iter = tasks.iterator();
		while(iter.hasNext()) {
			String[] temp = iter.next();
			String temp2 = temp[1];
			possible.remove(temp2);			
		}
		return possible;
	}

	@Override
	public boolean isWellSorted(String[] sequence) {
		Set<String> validTasks = possibleTasks();
		for(int i = 0; i<sequence.length; i++) {
			if(sequence[i] == null) {
				throw new NullPointerException();
			}
			if(! allTasks.contains(sequence[i])) {
				throw new java.util.NoSuchElementException();
			}
			
			String temp = sequence[i];
			if(! validTasks.contains(temp)) {
				return false;
			}
			Iterator<String[]> iter = tasks.iterator();
			while(iter.hasNext()) {
				String[] temp2 = iter.next();
				if(temp2[0]==temp) {
					validTasks.add(temp2[1]);
				}
			}			
		}
		return true;
		
	}

}
 