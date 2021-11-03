import java.util.Arrays;

public class PersonArray
{
    private Person[] people;

    {
        this.people = new Person[0];
    }

    public PersonArray() { }
    public PersonArray(PersonArray pa)
    {
        this.people = new Person[pa.people.length];
        System.arraycopy(pa.people, 0, this.people, 0, pa.people.length);
    }

    public void addPerson(Person new_person)
    {
        if(new_person == null)
            return;
        if(Arrays.asList(this.people).contains(new_person))
            return;

        var temp = new Person[this.people.length+1];
        System.arraycopy(this.people, 0, temp, 0, this.people.length);
        temp[this.people.length] = new_person;
        this.people = temp;
    }

    public void removePerson(Person person)
    {
        var index = Arrays.asList(this.people).indexOf(person);
        var small = new Person[this.people.length-1];
        System.arraycopy(this.people, 0, small, 0, index);
        System.arraycopy(this.people, index+1, small, index, this.people.length - index - 1);

        this.people = small;
    }

    public void sortByAge()
    {
        Arrays.sort(this.people, (Person one, Person two) ->
        {
            if(one.getAge() < two.getAge())
                return -1;
            else if(one.getAge() == two.getAge())
                return 0;
            else return 1; });
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(!o.getClass().equals(this.getClass()))
            return false;
        PersonArray pa = (PersonArray)o;
        return Arrays.equals(this.people, pa.people);
    }

    @Override
    public String toString()
    {
        return Arrays.toString(this.people);
    }

}