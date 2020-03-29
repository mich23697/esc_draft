<template>
    <div id="login">
        <nav class="navbar navbar-light bg-light">
            <a class="narbar-brand">Capstone Exhibition Dashboard</a>
            <a class="navbar-text ml-auto">For queries: &nbsp;<a href="https://www.sutd.edu.sg/Capstone">Capstone Office</a></a>
        </nav>
        <div class="jumbotron container col-lg-5 col-md-7 col-sm-9">
            <form>
                <div class="form-group">
                    <label for="groupId">Group Id</label>
                    <input required type="text" v-model="input.groupId" placeholder="Your Group ID" class="form-control" id="groupId" aria-describedby="groupIdDesc">
                    <small id="groupIdDesc" class="form-text text-muted">Please use the group ID provided to you by the Capstone Office</small>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input required type="password" v-model="input.password" placeholder="Password" class="form-control" id="password">
                </div>
                <button type="submit" v-on:click="login()" class="btn btn-primary">Login</button>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Login',
    data() {
        return {
            input: {
                groupId: "",
                password: ""
            }
        }
    },
    methods: {
        login() {
            if(this.input.groupId != "" && this.input.password != "") {
                if(this.input.groupId == this.$parent.account.groupId 
                    && this.input.password == this.$parent.account.password) {
                        this.$emit("authenticated", true);
                        this.$router.replace({ name: "Student" });
                } else if(this.input.groupId == "admin" && this.input.password == "admin") {
                    this.$emit("authenticated", true);
                    this.$router.replace({name: "Admin"});
                } else {
                    console.log("The group id and/or password is incorrect");
                }
            } else {
                console.log("You must provide your group id and password.");
            }
        }
    }
}
</script>

<style>
    .jumbotron{
        margin-top: 1.5em;
        padding: 1.5em;
    }
</style>