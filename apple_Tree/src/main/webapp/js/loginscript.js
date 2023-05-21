const showform = document.querySelector('#showform')
const form = document.querySelector('#form')
const close = document.querySelector('#close')
const username = document.querySelector('#username')
const password = document.querySelector('#password')

showform.addEventListener('click', () => {
	showform.style.top = '100vh'
	setTimeout(() => {
		form.style.top = 'calc(100vh - 316px)'
	}, 200)
})
close.addEventListener('click', () => {
	form.style.top = '100vh'
	setTimeout(() => {
		username.value = ''
		password.value = ''
		showform.style.top = 'calc(100vh - 50px)'
	}, 300)
})