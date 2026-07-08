import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [new Post(0, 'Loading posts...', 'Please wait while the posts are loaded.')],
      errorMessage: ''
    };
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error) {
    alert(`Error occurred in Posts component: ${error.message}`);
    this.setState({ errorMessage: error.message });
  }

  async loadPosts() {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/posts');
      if (!response.ok) {
        throw new Error('Unable to load posts');
      }

      const data = await response.json();
      const posts = data.map((item) => new Post(item.id, item.title, item.body));
      this.setState({ posts });
    } catch (error) {
      this.componentDidCatch(error);
    }
  }

  render() {
    const { posts, errorMessage } = this.state;

    return (
      <div className="posts-panel">
        {errorMessage ? <p className="error-text">{errorMessage}</p> : null}
        {posts.map((post) => (
          <article className="post-item" key={post.id}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </article>
        ))}
      </div>
    );
  }
}

export default Posts;
