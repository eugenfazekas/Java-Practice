import java.util.List;

public class OrCriteria implements Criteria {
	
	private Criteria criteria;
	private Criteria othercriteria;
		
	public OrCriteria(Criteria criteria, Criteria othercriteria) {
		this.criteria = criteria;
		this.othercriteria = othercriteria;
	}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {

		List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
		List<Person> othercriteriItems = othercriteria.meetCriteria(persons);
		
		for(Person person : othercriteriItems) {
			if(!firstCriteriaItems.contains(person)) {
				firstCriteriaItems.add(person);
			}
		}
		return firstCriteriaItems;
	}
}
