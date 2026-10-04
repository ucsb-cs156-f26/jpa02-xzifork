package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_result() {
        assert(team.equals(team));
        assert(!team.equals(new String("test-team")));

        Team sameTeam = new Team("test-team");
        Team differentTeam = new Team("different-team");

        assert(team.equals(sameTeam));

        sameTeam.addMember("member1");
        assert(!team.equals(sameTeam));
        
        assert(!team.equals(differentTeam));
        differentTeam.addMember("member1");
        assert(!team.equals(differentTeam));
    }

    @Test
    public void hashCode_returns_correct_hash() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());

        t2.setName("baz");
        assert(t1.hashCode() != t2.hashCode());
        t2.addMember("baz");
        assert(t1.hashCode() != t2.hashCode());

        // cheat
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }

}
