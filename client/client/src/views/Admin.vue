<template>
    <div id="Admin">
        <nav>
            <a class="navbar-brand">Capstone Exhibition - Admin</a>
        </nav>
        <div class="jumbotron">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Group ID</th>
                        <th scope="col">Category</th>
                        <th scope="col">Dimension</th>
                        <th scope="col">Height</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(submission, index) in submissions" v-bind:key="index">
                        <td> {{ index + 1 }} </td>
                        <th> {{ submission.category }}</th>
                        <td> {{ submission.width }} <span>m x &nbsp;</span> {{ submission.length }} <span>m</span> </td>
                        <td> {{ submission.height }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
   name: 'Admin',
   data() {
       return {
           submissions: []
       }
   },
   created() {
       axios.get('http://localhost:3000/submissions')
       .then(response => {
           this.submissions = response.data
       })
   }
}
</script>