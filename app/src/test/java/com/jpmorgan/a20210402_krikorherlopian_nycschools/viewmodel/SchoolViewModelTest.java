package com.jpmorgan.a20210402_krikorherlopian_nycschools.viewmodel;

import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.School;
import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;
import java.util.Arrays;
import java.util.List;
public class SchoolViewModelTest {

    School a = new School("ABC");
    School b = new School("BAC");
    School c = new School("CDE");
    School d = new School("DEC");
    @Test
    public void sortBySchoolName() {
        List<School> schoolList = Arrays.asList(c, b, d, a);
        List<School> schoolListOrdered = Arrays.asList(a, b, c, d);

        SchoolViewModel.sortBySchoolName(schoolList);
        //this test will pass, as schoollist will be ordered after calling SchoolViewModel.sortBySchoolName(schoolList)
        assertThat(schoolList).isEqualTo(schoolListOrdered);
    }

    @Test
    public void compareTwoListWithoutSorting(){
        List<School> schoolList = Arrays.asList(c, b, d, a);
        List<School> schoolListOrdered = Arrays.asList(a, b, c, d);
        //this test will fail, as schoolList is not sorted.
        assertThat(schoolList).isEqualTo(schoolListOrdered);

    }
}