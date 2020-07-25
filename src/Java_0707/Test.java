package Java_0707;

public class Test {
    static class card {
        int rank;

        @Override
        public boolean equals(Object o ) {
            if(this == o) {
                return true;
            }
            if(o == null) {
                return false;
            }
            if(!(o instanceof card)) {
                return false;
            }
            card tmp = (card) o;
            return tmp.rank == this.rank;
        }

    }
}
