package me.devksh930.tabling.app;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommonArchTest {


    @Test
    @DisplayName("common은 auth를 참조할수 없다")
    void commonShouldNotAccessAuth() {
        JavaClasses importedClass = new ClassFileImporter().importPackages(
            "me.devksh930.tabling.app");
        ArchRule rule = noClasses().that().resideInAPackage("..common..").should()
            .accessClassesThat().resideInAPackage("..auth..");
        rule.check(importedClass);
    }

    @Test
    @DisplayName("common은 account를 참조할수 없다")
    void commonShouldNotAccessAccount() {
        JavaClasses importedClass = new ClassFileImporter().importPackages(
            "me.devksh930.tabling.app");
        ArchRule rule = noClasses().that().resideInAPackage("..common..").should()
            .accessClassesThat().resideInAPackage("..account..");
        rule.check(importedClass);
    }

    @Test
    @DisplayName("common은 infrastructure를 참조할수 없다")
    void commonShouldNotAccessInfraStructure() {
        JavaClasses importedClass = new ClassFileImporter().importPackages(
            "me.devksh930.tabling.app");
        ArchRule rule = noClasses().that().resideInAPackage("..common..").should()
            .accessClassesThat().resideInAPackage("..infrastructure..");
        rule.check(importedClass);
    }

    @Test
    @DisplayName("common은 reserve를 참조할수 없다")
    void commonShouldNotAccessReserve() {
        JavaClasses importedClass = new ClassFileImporter().importPackages(
            "me.devksh930.tabling.app");
        ArchRule rule = noClasses().that().resideInAPackage("..common..").should()
            .accessClassesThat().resideInAPackage("..reserve..");
        rule.check(importedClass);
    }

    @Test
    @DisplayName("common은 store를 참조할수 없다")
    void commonShouldNotAccessStore() {
        JavaClasses importedClass = new ClassFileImporter().importPackages(
            "me.devksh930.tabling.app");
        ArchRule rule = noClasses().that().resideInAPackage("..common..").should()
            .accessClassesThat().resideInAPackage("..store..");
        rule.check(importedClass);
    }
}
