package edziekanat.servlet.database;

/**
 * Enum representing tables created in database.
 * 
 * @author Marcin Muskala
 *
 */
public enum TableTypes
{
    ADMINISTRATOR, STUDENT, LECTURER, PARTIAL_ASSESSMENT, SCHOLARSHIP, STUDENT_GROUP, 
    INDEX, SUBJECT, COURSE, MESSAGE, LEARNING_MATERIALS, PAYMENT, LECTURES_ROOM, 
    APPLICATION, COLLEGE, ENTRY, DEPARTMENT, PLANNED_CLASSES;

    /**
     * Method overriding toString method returns string with corresponding table
     * name in database.
     */
    public String toString()
    {
	switch (this)
	{
	case ADMINISTRATOR:
	    return "'administrator'";
	case STUDENT:
	    return "'student'";
	case LECTURER:
	    return "'pracowniknaukowodydaktyczny'";
	case PARTIAL_ASSESSMENT:
	    return "'ocenaczastkowa'";
	case SCHOLARSHIP:
	    return "'stypendium'";
	case STUDENT_GROUP:
	    return "'grupastudencka'";
	case INDEX:
	    return "'indeks'";
	case SUBJECT:
	    return "'przedmiot'";
	case COURSE:
	    return "'kierunek'";
	case MESSAGE:
	    return "'komunikat'";
	case LEARNING_MATERIALS:
	    return "'materialydydaktyczne'";
	case PAYMENT:
	    return "'naleznosci'";
	case LECTURES_ROOM:
	    return "'salazajeciowa'";
	case APPLICATION:
	    return "'wniosek'";
	case COLLEGE:
	    return "'uczelnia'";
	case ENTRY:
	    return "'wpis'";
	case DEPARTMENT:
	    return "'wydzial'";
	case PLANNED_CLASSES:
	    return "'zaplanowanezajecia'";
	default:
	    return "error";
	}
    }
}
