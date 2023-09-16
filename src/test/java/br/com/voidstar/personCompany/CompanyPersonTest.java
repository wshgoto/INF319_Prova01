package br.com.voidstar.personCompany;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class CompanyPersonTest {
    private static Company ca, cb, cc, cd;

    private static Engineer pa, pb;
    private static Seller pc;
    private static Manager pd;

    @Before
    public void setUp() throws Exception {

        ca = new Company();
        cb = new Company("CB");
        cc = new Company("CC");
        cd = new Company("CD");

        pa = new Engineer("A", "AA");
        pb = new Engineer("B", "BB");
        pc = new Seller("C", "CC");
        pd = new Manager("D", "DD");

    }

    @After
    public void tearDown() throws Exception {
        // No action necessary here.
    }

    @Test
    public void test() {
        // Test the state of ca after its construction.
        assertEquals(ca.getName(), "");
        assertEquals(ca.getNumberOfEmployees(), 0);
        assertEquals(ca.payroll(), 0.0, 0.0);

        // Test the state of cb after its construction.
        assertEquals(cb.getName(), "CB");
        assertEquals(cb.getNumberOfEmployees(), 0);
        assertEquals(cb.payroll(), 0.0, 0.0);

        // Test construction of cc
        assertEquals(cc.getName(), "CC");
        assertEquals(cc.getNumberOfEmployees(), 0);

        cc.setName("Sucupira");
        assertEquals(cc.getName(), "Sucupira");
        assertEquals(cc.payroll(), 0.0, 0.0);

        // CC hires PA, PB, PC
        cc.hire(pa, 1000.0);
        assertEquals(cc.getNumberOfEmployees(), 1);
        assertEquals(cc.payroll(), 1000.0, 0.0);
        cc.hire(pb, 1100.0);
        assertEquals(cc.payroll(), 2100.00, 0.0);
        cc.hire(pc, 1200.0);
        assertEquals(cc.payroll(), 3300.0, 0.0);
        assertEquals(cc.getNumberOfEmployees(), 3);
        pa.setProjectBonus(100.0);
        assertEquals(cc.payroll(), 3400.0, 0.0);
        pb.setProjectBonus(100.0);
        pc.setCommision(200.0);
        assertEquals(3700.0, cc.payroll(), 0.0);

        // PA changes jobs from CC to CA
        ca.hire(pa, 1000.0);
        pa.setProjectBonus(250.0);
        assertEquals(ca.payroll(), 1250.0, 0.0);
        assertTrue(ca.employed(pa));
        assertFalse(cc.employed(pa));



        // a person cannot hire herself in a company
        // that has already hired her
        pa.selfHire(ca, 2000.00);
        // but as it is already hired, the bonus can be changed.
        pa.setProjectBonus(150.00);
        assertTrue(ca.employed(pa));
        // the salary of the person remains the salary
        // assigned to her at the first employment
        assertEquals(pa.getSalary(), 1150.00, 0.0);
        pa.selfDismiss(ca);
        assertFalse(ca.employed(pa));
        assertEquals(pa.getSalary(), 0.0, 0.0);
        assertEquals(0.0, pa.getProjectBonus(), 0.0);

        ca.hire(pa, 3000.00);
        assertEquals(ca.payroll(), 3000.00, 0.0);
        ca.hire(pb, 2000.00);
        assertEquals(ca.payroll(), 5000.00, 0.0);
        // a person cannot be hired twice in the same Company
        ca.hire(pb, 2500.00);
        assertEquals(ca.payroll(), 5000.00, 0.0);
        ca.hire(pc, 5000.00);
        pc.setCommision(500.0);
        assertEquals(ca.payroll(), 10500.00, 0.0);
        assertEquals(pa.getCompany(), ca);
        assertEquals(pb.getCompany(), ca);
        assertEquals(pc.getCompany(), ca);
        // a company can dismiss a person
        ca.dismiss(pa);
        // a person can dismiss itself, if employed.
        pa.selfDismiss(ca);

        // a person can dismiss itself, if employed
        pb.selfDismiss(ca);
        assertNull(pb.getCompany());
        // a company can dismiss a person, if the person is employed at the company
        // otherwise dismissal is a no-op.
        ca.dismiss(pb);
        // Dismissal of a non-employee is a no-op.
        ca.dismiss(pb);
        assertFalse(ca.employed(pb));
        ca.hire(pb, 1000.00);
        assertEquals(pb.getSalary(), 1000.00, 0.0);
        assertEquals(ca.payroll(), 6500.00, 0.0);

        // A person can be employed in only and only one company
        cb.hire(pb, 5000.0);
        assertEquals(cb.payroll(), 5000.0, 0.0);
        assertEquals(pb.getSalary(), 5000.0, 0.0);
        cd.hire(pb, 6000.0);
        assertEquals(cb.payroll(), 0.0, 0.0);
        assertEquals(cd.payroll(), 6000.0, 0.0);
        assertEquals(pb.getSalary(), 6000.0, 0.0);
        cd.hire(pb, 7000.0);
        // It is not possible to update the salary of an employee
        // using the method hire.
        assertEquals(pb.getSalary(), 6000.0, 0.0);
        // Dismiss and re-hire can be used to update the
        // salary of an employee
        cd.dismiss(pb);
        cd.hire(pb, 7000.0);
        assertEquals(pb.getSalary(), 7000.0, 0.0);
        assertEquals(cd.payroll(), 7000.0, 0.0);
        assertEquals(cd.getNumberOfEmployees(), 1);

        // hire and selfHire, dismiss and selfDismiss
        // are interchangeable
        pb.selfDismiss(cd);
        assertEquals(cd.getNumberOfEmployees(), 0);
        cd.hire(pb, 8000.0);
        assertEquals(cd.payroll(), 8000.0, 0.0);
        assertEquals(cd.getNumberOfEmployees(), 1);
        cd.dismiss(pb);
        pb.selfHire(cd, 8500.0);
        assertEquals(cd.payroll(), 8500.0, 0.0);
    }
}
