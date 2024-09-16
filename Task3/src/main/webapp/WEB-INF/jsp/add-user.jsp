<%@ include file="common/navigation.jspf"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
    <p>Add/Update User:</p>
    <form:form method="post" modelAttribute="user">

        <form:label path="name">Name</form:label>
        <form:input path="name" type="text" required="required" />
        <form:errors path="name" />

        <form:label path="surname">Surname</form:label>
        <form:input path="surname" type="text" required="required" />
        <form:errors path="surname" />

        <form:label path="phoneNumber">Phone Number</form:label>
        <form:input path="phoneNumber" type="text" required="required" />
        <form:errors path="phoneNumber" />

        <form:label path="email">Email</form:label>
        <form:input path="email" type="text" required="required" />
        <form:errors path="email" />

        <form:label path="address">Address</form:label>
        <form:input path="address" type="text" required="required" />
        <form:errors path="address" />

        <form:label path="password">Password</form:label>
        <form:input path="password" type="text" required="required" />
        <form:errors path="password" />


        <button type="submit">OK</button>
    </form:form>
</div>