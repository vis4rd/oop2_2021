public class Person
{
    private String firstName;
    private String lastName;
    private int age;
    private int weight;
    private int height;

    {
        this.firstName = new String();
        this.lastName = new String();
        this.age = 0;
        this.weight = 0;
        this.height = 0;
    }

    private Person() {}
    private Person(String fname, String lname, int age, int w, int h)
    {
        this.firstName = fname;
        this.lastName = lname;
        this.age = age;
        this.weight = w;
        this.height = h;
    }

    public static final class Builder
    {
        private String firstName;
        private String lastName;
        private int age;
        private int weight;
        private int height;

        public Builder firstName(String fname) { this.firstName = fname; return this; }
        public Builder lastName(String lname) { this.lastName = lname; return this; }
        public Builder age(int age) { this.age = age; return this; }
        public Builder weight(int w) { this.weight = w; return this; }
        public Builder height(int h) { this.height = h; return this; }
        public Person build()
        {
            if(this.firstName == null || this.firstName.isEmpty())
            {
                System.out.println("First name is not given.");
                return null;
            }
            else if(this.lastName == null || this.lastName.isEmpty())
            {
                System.out.println("Last name is not given.");
                return null;
            }
            else if(this.age == 0)
            {
                System.out.println("Age is not given.");
                return null;
            }
            else if(this.weight == 0)
            {
                System.out.println("Weight is not given.");
                return null;
            }
            else if(this.height == 0)
            {
                System.out.println("Height is not given.");
                return null;
            }
            Person p = new Person();
            p.firstName = this.firstName;
            p.lastName = this.lastName;
            p.age = this.age;
            p.weight = this.weight;
            p.height = this.height;
            return p;
        }
    }

    @Override
    public String toString()
    {
        return "Person{firstName="+this.firstName+", lastName="+this.lastName+", age="+this.age+
            ", weight="+this.weight+", height="+this.height+"}";
    }

    @Override
    public boolean equals(Object p)
    {
        if(p == null)
            return false;
        if(!p.getClass().equals(getClass()))
            return false;
        
        Person q = (Person)p;
        return this.firstName.equals(q.firstName)
            && this.lastName.equals(q.lastName)
            && ( this.age == q.age )
            && ( this.weight == q.weight )
            && ( this.height == q.height );
    }

    public int getAge()
    {
        return this.age;
    }
}