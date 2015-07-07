package me.vpineda.ui.test;

import me.vpineda.request.CourseFactory;
import me.vpineda.request.test.CourseSubjectFactoryTest;
import me.vpineda.ui.MainUI;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vpineda1996 on 2015-05-26.
 */
public class MainUITest extends CourseSubjectFactoryTest {
    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testFillInListWithCourseSubject() throws Exception {
        CourseFactory.getInstance().parseCourses(serverResponse);
        MainUI.main(new String[]{});

    }
}
