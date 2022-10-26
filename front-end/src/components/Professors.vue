<template>
  <div class="hello">
    <h2> Professors </h2>
    <b-table striped hover stacked :items="professors" :fields="fields">
      <template #cell(actions)="row">
        <b-button size="sm" v-b-modal.edit-modal @click="edit(row.item, row.index, $event.target)">
          Edit
        </b-button>
      </template>
    </b-table>
    <b-modal id="edit-modal" title="Edit Professor" @hide="resetEditModal" hide-footer>
      <b-form >

        <label class="sr-only" for="input-id">Professor ID</label>
        <b-form-input
          id='input-id'
          v-model="form.id"
          placeholder="Professor ID"
          readonly
        ></b-form-input>

        <label class="sr-only" for="input-first-name">First Name</label>
        <b-form-input
          id='input-first-name'
          v-model="form.first_name"
          placeholder="First Name"
          required
        ></b-form-input>

        <label class="sr-only" for="input-last-name">Last Name</label>
        <b-form-input
          id="input-last-name"
          v-model="form.last_name"
          placeholder="Last Name"
          required
        ></b-form-input>

        <label class="sr-only" for="input-email">Email</label>
        <b-input-group prepend="@" >
          <b-form-input id="input-email" v-model="form.email" placeholder="Email" required></b-form-input>
        </b-input-group>

        <label class="sr-only" for="input-office">Office</label>
        <b-form-input
          id="input-office"
          v-model="form.office"
          placeholder="Office"
          required
        ></b-form-input>
        
        <br />
        <b-button type="submit" variant="primary">Submit</b-button>
        <b-button type="reset" variant="warning">Reset</b-button>
        <b-button type="button" variant="danger">Remove Professor</b-button>
      </b-form>

    </b-modal>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Professors',
  data () {
    return {
      professors: null,
      fields: [
      {key: 'id', label: 'Professor ID', sortable: true},
      {key: 'lastName', label: 'Last Name', sortable: true},
      {key: 'firstName', label: 'First Name', sortable: true},
      {key: 'email', label: 'Email', sortable: true, sortable: true},
      {key: 'office', label: 'Office'},
      {key: 'actions', label: 'Actions'}],
      form: {
          email: '',
          first_name: '',
          last_name: '',
          office: '',
          id: ''
        },
    }
  },
  mounted () {
    axios
      .get('http://localhost:8085/professors')
      .then(response => (this.professors = response.data))
  },
  methods: {
    edit(item, index, button) {
      this.form.id = item.id
      this.form.email = item.email
      this.form.first_name = item.firstName
      this.form.last_name = item.lastName
      this.form.office = item.office
    },
    resetEditModal() {
      this.form.id=''
      this.form.email=''
      this.form.first_name=''
      this.form.last_name=''
      this.form.office=''
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
