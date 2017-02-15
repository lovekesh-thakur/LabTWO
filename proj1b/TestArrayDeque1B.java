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
        OperationSequence ops = new OperationSequence();
        /* randomly calling functions */
        for(int i = 0; i < 505; i++)
        {
            int rand = StdRandom.uniform(0,30);
            DequeOperation op;
            if(rand < 2)
            {
                if(student.size() > 0) {
                    op = new DequeOperation("removeFirst");
                    ops.addOperation(op);
                    student.removeFirst();
                    prof.removeFirst();
                }
            }
            if(rand < 10 && (rand >= 3))
            {
                op = new DequeOperation("addLast", rand);
                ops.addOperation(op);
                student.addLast(rand);
                prof.addLast(rand);
            }
            if(rand >= 10 && (rand < 28) )
            {
                op = new DequeOperation("addFirst", rand);
                ops.addOperation(op);
                student.addFirst(rand);
                prof.addFirst(rand);
            }
            if(rand >= 28)
            {
                if(student.size() > 0)
                {
                    op = new DequeOperation("removeLast");
                    ops.addOperation(op);
                    student.removeLast();
                    prof.removeLast();
                }
            }

            if((i % 4) == 0)
            {
                System.out.println("Testing...");
                // Checking at every fifth step
                if(student.size() > 0) {
                    int get_random = StdRandom.uniform(0, student.size());
                    Integer x = student.get(get_random);
                    Integer y = prof.get(get_random);
                    assertEquals('\n' + ops.toString(), y, x);


                }
            }

        }


    }
}
