<template>
    <div id="student">
        <nav class="navbar navbar-light bg-light">
            <a class="navbar-brand">Capstone Exhibition Dashboard - Student</a>
        </nav>
        <StudentHome/>
    </div>
</template>

<script>
import StudentHome from '../components/StudentHome.vue'

export default {
    name: 'Student',
    components: {
        StudentHome
    }
}
</script>