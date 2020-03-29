<template>
    <div>
        <div class="jumbotron container col-lg-5 col-md-7 col-sm-9">
            <h2>Exhibition Booth Requirement</h2>
            <hr>
            <form>
                <!-- <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            Category
                        </span>
                    </div>
                    <select class="form-control" v-model="input.category">
                        <option value="cat1">Category 1</option>
                        <option value="cat2">Category 2</option>
                        <option value="cat3">Category 3</option>
                    </select>
                </div> -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            Industry
                        </span>
                    </div>
                    <select class="form-control" v-model="input.category">
                        <option value="Aerospace">Aerospace</option>
                        <option value="Banking">Banking</option>
                        <option value="Biotechnology">Biotechnology</option>
                        <option value="Chemicals">Chemicals</option>
                        <option value="Electronics">Electronics</option>
                        <option value="Investment">Investment</option>
                        <option value="Gaming">Gaming</option>
                        <option value="Pharmaceuticals">Pharmaceuticals</option>
                        <option value="Semi-Conductor">Semi-Conductor</option>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            Dimension
                        </span>
                    </div>
                    <input type="number" class="form-control" v-model="input.width">
                    <div class="input-group-append">
                        <span class="input-group-text">
                            m
                        </span>
                    </div>
                    <span class="input-group-text" style="border:None">
                        x
                    </span>
                    <input type="number" class="form-control" v-model="input.length">
                    <div class="input-group-append">
                        <span class="input-group-text">
                            m
                        </span>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">
                            Height
                        </span>
                    </div>
                    <input type="number" class="form-control" v-model="input.height">
                    <div class="input-group-append">
                        <span class="input-group-text">
                            m
                        </span>
                    </div>
                </div>
                <button type="submit" v-on:click="submit_requirement()" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'StudentHome',
    data() {
        return {
            errors: [],
            input: {
                category: "",
                width: "",
                length: "",
                height: ""
            }
        }
    },
    methods: {
        submit_requirement() {
            axios.post('http://localhost:3000/submit', this.input)
        }
    }
}
</script>