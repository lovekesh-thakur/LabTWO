/**
 * Created by lovekesh on 14/2/17.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

    @Test
    public void testArrayDeque()
    {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> prof = new ArrayDequeSolution<>();
        /* randomly calling functions */
        for(int i = 0; i < 300; i++)
        {
            int rand = StdRandom.uniform(0,30);
            if(rand < 5 && (student.size() > 0) )
            {
                student.removeFirst();
                prof.removeFirst();
            }else
            {
                student.addLast(rand);
                prof.addLast(rand);
            }
            if(rand > 10 && (rand < 20) )
            {
                student.addFirst(rand);
                prof.addFirst(rand);
            }else
            {
                if(student.size() > 0)
                {
                    student.removeLast();
                    prof.removeLast();
                }
            }
            if(i % 5 == 0)
            {
                System.out.println("Testing...");
                // Checking at every fifth step
                if(student.size() > 0) {
                    int get_random = StdRandom.uniform(0, student.size());
                    Integer x = student.get(get_random);
                    Integer y = prof.get(get_random);
                    if (x != y) {
                        System.out.println("Item do not match at position " + get_random + " Expected " + y + " but got " + x);
                        System.out.println("Your deque contains...");
                        student.printDeque();
                        System.out.println("prof deque contains...");
                        for(int j = 0; j < prof.size(); j++)
                        {
                            System.out.print(prof.get(j) + " ");
                        }
                        System.out.println();
                        System.exit(0);
                    }
                }
            }

        }

    }
}
